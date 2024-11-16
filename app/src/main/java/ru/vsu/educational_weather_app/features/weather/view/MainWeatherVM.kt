package ru.vsu.educational_weather_app.features.weather.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import ru.vsu.educational_weather_app.features.settings.domain.SettingsUseCase
import ru.vsu.educational_weather_app.features.weather.data.WeatherRepository
import ru.vsu.educational_weather_app.features.weather.models.Weather

class MainWeatherVM(private val repository: WeatherRepository, private val settings: SettingsUseCase): ViewModel() {
    private val _weatherState = MutableStateFlow<Weather?>(null)
    val weatherState: SharedFlow<Weather?> = _weatherState

    private val _cityState = MutableStateFlow("Воронеж")
    val cityState: SharedFlow<String> = _cityState

    init {
        viewModelScope.launch {
            _weatherState.value = repository.getCurrentWeather(cityName = _cityState.value, lang=settings.language.value)
        }
    }

    fun updateWeather() {
        viewModelScope.launch {
            _weatherState.value = repository.getCurrentWeather(cityName = _cityState.value, lang=settings.language.value)
        }
    }
}