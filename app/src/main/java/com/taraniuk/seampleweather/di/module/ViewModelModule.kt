package com.taraniuk.seampleweather.di.module

import androidx.lifecycle.ViewModelProvider
import com.taraniuk.seampleweather.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
