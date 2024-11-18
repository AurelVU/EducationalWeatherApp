package ru.vsu.educational_weather_app.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vsu.educational_weather_app.features.settings.view.SettingsVM
import ru.vsu.educational_weather_app.features.weather.view.MainWeatherVM
import ru.vsu.educational_weather_app.features.cities.view.CitiesVM

val appModule = module {
    viewModelOf(::MainWeatherVM)
    viewModelOf(::SettingsVM)
    viewModelOf(::CitiesVM)
}