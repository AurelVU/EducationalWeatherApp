package ru.vsu.educational_weather_app.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vsu.educational_weather_app.features.weather.view.MainWeatherVM

val appModule = module {
    viewModelOf(::MainWeatherVM)
}