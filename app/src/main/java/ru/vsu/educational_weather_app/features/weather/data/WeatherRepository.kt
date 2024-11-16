package ru.vsu.educational_weather_app.features.weather.data

import ru.vsu.educational_weather_app.features.weather.models.Weather

interface WeatherRepository {
    suspend fun getCurrentWeather(cityName: String): Weather; // лишняя ;
}

class WeatherRepositoryImpl(private val service: WeatherService): WeatherRepository {
    override suspend fun getCurrentWeather(cityName: String): Weather {
        val body = service.weatherByCity(cityName, "ru").body()!!
        return body
    }
}