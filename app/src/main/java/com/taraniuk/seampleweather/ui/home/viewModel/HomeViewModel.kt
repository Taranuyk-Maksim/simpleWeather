package com.taraniuk.seampleweather.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taraniuk.seampleweather.data.RequestResult
import com.taraniuk.seampleweather.data.repository.WeatherRepository
import com.taraniuk.seampleweather.data.retrofit.model.CityResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {

    private val weatherLiveData = MutableLiveData<CityResponse>()

    fun getWeatherInCity(city: String): LiveData<CityResponse> {
        viewModelScope.launch {
            when (val response = repository.getCityWeatherData(city)) {
                is RequestResult.OnSuccess -> {
                    Log.d("CityWeather", "getWeatherInCity: ${response.data}")
                    weatherLiveData.value = response.data
                }
                is RequestResult.OnError -> {
                    Log.d("CityWeather", "getWeatherInCity: ${response.error}")
                }
            }
        }
        return weatherLiveData
    }

}