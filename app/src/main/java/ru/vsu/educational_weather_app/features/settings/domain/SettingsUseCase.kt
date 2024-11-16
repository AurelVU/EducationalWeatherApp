package ru.vsu.educational_weather_app.features.settings.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsUseCase {
    private val _language = MutableStateFlow("ru")
    var language: StateFlow<String> = _language

    fun setLanguage(lang: String) { _language.value = lang }
}