package com.taraniuk.seampleweather.ui.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.taraniuk.seampleweather.WeatherApp
import com.taraniuk.seampleweather.databinding.HomeFragmetBinding
import com.taraniuk.seampleweather.di.module.BASE_IMAGE_URL
import com.taraniuk.seampleweather.ui.home.viewModel.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel
    lateinit var binding: HomeFragmetBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        WeatherApp.daggerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = HomeFragmetBinding.inflate(inflater)

        viewModel.getWeatherInCity("KIEV").observe(viewLifecycleOwner, {
            binding.text.text = it.toString()
            setImage(binding.sun, it.weather[0].icon)
        })

        return binding.root
    }

    private fun setImage(image: ImageView, imageId: String) {
        Glide.with(this)
            .load("${BASE_IMAGE_URL}w/$imageId.png")
            .centerCrop()
            .into(image)
    }

}