package ru.vsu.educational_weather_app.di

import org.koin.dsl.module
import ru.vsu.educational_weather_app.features.settings.domain.SettingsUseCase

val domainModule = module {
    single {
        SettingsUseCase()
    }
}