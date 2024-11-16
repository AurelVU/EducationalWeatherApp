package ru.vsu.educational_weather_app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.vsu.educational_weather_app.di.appModule
import ru.vsu.educational_weather_app.di.dataModule
import ru.vsu.educational_weather_app.di.domainModule
import ru.vsu.educational_weather_app.di.networkModule


class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(networkModule, dataModule, domainModule, appModule)
        }
    }
}