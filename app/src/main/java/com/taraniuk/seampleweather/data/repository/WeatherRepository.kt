package com.taraniuk.seampleweather.data.repository

import com.taraniuk.seampleweather.data.RequestResult
import com.taraniuk.seampleweather.data.retrofit.api.OpenWeatherApi
import com.taraniuk.seampleweather.data.retrofit.model.CityResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

const val headerHost = "community-open-weather-map.p.rapidapi.com"
const val headerKey = "f839eaa5e6msh42300a932e1d65ep1be03fjsn0033badad007"

class WeatherRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    suspend fun getCityWeatherData(city: String): RequestResult<CityResponse> {
        return withContext(Dispatchers.IO) {
            try {
                RequestResult.withValue(
                    retrofit.create(OpenWeatherApi::class.java)
                        .getWeatherDataInSetCity(
                            headerHost, headerKey, city)
                )
            } catch (ex: Exception) {
                RequestResult.withError(ex)
            }
        }
    }
}