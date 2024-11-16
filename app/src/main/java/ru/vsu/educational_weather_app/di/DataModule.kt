package ru.vsu.educational_weather_app.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vsu.educational_weather_app.features.weather.data.WeatherRepository
import ru.vsu.educational_weather_app.features.weather.data.WeatherRepositoryImpl


val dataModule = module {
    singleOf(::WeatherRepositoryImpl) {
        bind<WeatherRepository>()
    }
}
