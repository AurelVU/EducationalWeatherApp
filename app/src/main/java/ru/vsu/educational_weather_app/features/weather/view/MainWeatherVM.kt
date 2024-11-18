package ru.vsu.educational_weather_app.features.weather.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.vsu.educational_weather_app.features.settings.domain.SettingsUseCase
import ru.vsu.educational_weather_app.features.weather.data.WeatherRepository
import ru.vsu.educational_weather_app.features.weather.models.Weather

class MainWeatherVM(private val repository: WeatherRepository, private val settings: SettingsUseCase): ViewModel() {
    private val _weatherState = MutableLiveData<Weather?>(null)
    val weatherState: LiveData<Weather?> = _weatherState

    private val _cityState = MutableLiveData("Воронеж")
    val cityState: LiveData<String> = _cityState

    init {
        viewModelScope.launch {
            _weatherState.value = repository.getCurrentWeather(
                cityName = _cityState.value!!,
                lang=settings.language.value!!,
            )
        }
    }

    fun updateWeather() {
        viewModelScope.launch {
            _weatherState.value = repository.getCurrentWeather(
                cityName = _cityState.value!!,
                lang=settings.language.value!!,
            )
        }
    }
}