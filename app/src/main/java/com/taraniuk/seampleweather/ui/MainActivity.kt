package com.taraniuk.seampleweather.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.taraniuk.seampleweather.R
import com.taraniuk.seampleweather.WeatherApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApp.daggerComponent.inject(this)
        setContentView(R.layout.activity_main)
        val textResponse = findViewById<TextView>(R.id.text)

        viewModel.getWeatherInCity("KIEV").observe(this, {
            textResponse.text = it.toString()
        })

    }
}