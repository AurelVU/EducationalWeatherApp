package ru.vsu.educational_weather_app.features.settings.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SettingsUseCase {
    private val _language = MutableLiveData("ru")
    var language: LiveData<String> = _language

    fun setLanguage(lang: String) { _language.value = lang }
}