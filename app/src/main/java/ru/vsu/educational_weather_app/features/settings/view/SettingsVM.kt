package ru.vsu.educational_weather_app.features.settings.view

import androidx.lifecycle.ViewModel
import ru.vsu.educational_weather_app.features.settings.domain.SettingsUseCase

class SettingsVM(private val settingsUseCase: SettingsUseCase): ViewModel() {
    fun changeLang(lang: String) {
        settingsUseCase.setLanguage(lang)
    }
}