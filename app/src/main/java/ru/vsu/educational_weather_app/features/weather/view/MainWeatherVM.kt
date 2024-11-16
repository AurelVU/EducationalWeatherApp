package ru.vsu.educational_weather_app.features.weather.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vsu.educational_weather_app.features.weather.data.WeatherRepository
import ru.vsu.educational_weather_app.features.weather.models.Weather

class MainWeatherVM(private val repository: WeatherRepository): ViewModel() {
    // flow кайф дружить с компоуз, а вот с view лучше LiveData
    val weatherState = MutableStateFlow<Weather?>(null)
    val cityState = MutableStateFlow<String>("Воронеж")

    fun updateWeather() {
        viewModelScope.launch {
            weatherState.value = repository.getCurrentWeather(cityName = cityState.value)
        }
    }
}