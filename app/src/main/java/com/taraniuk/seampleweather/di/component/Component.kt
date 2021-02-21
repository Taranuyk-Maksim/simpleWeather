package com.taraniuk.seampleweather.di.component

import android.app.Application
import com.taraniuk.seampleweather.di.module.AppModule
import com.taraniuk.seampleweather.di.module.NetModule
import com.taraniuk.seampleweather.di.module.ViewModelModule
import com.taraniuk.seampleweather.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        ViewModelModule::class,
    ]
)
@Singleton
interface Component {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): com.taraniuk.seampleweather.di.component.Component

        @BindsInstance
        fun application(application: Application): Builder
    }
}