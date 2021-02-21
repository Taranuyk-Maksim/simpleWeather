package com.taraniuk.seampleweather

import android.app.Application
import com.taraniuk.seampleweather.di.component.Component
import com.taraniuk.seampleweather.di.component.DaggerComponent

class WeatherApp : Application() {

    companion object {
        lateinit var daggerComponent: Component
    }

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerComponent.builder().application(this).build()
    }
}