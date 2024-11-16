package ru.vsu.educational_weather_app.features.weather.data

import retrofit2.Response
import retrofit2.http.Query
import retrofit2.http.GET
import ru.vsu.educational_weather_app.features.weather.models.Weather

interface WeatherService {
    @GET("v1/current.json")
    suspend fun weatherByCity(@Query("q") city: String, @Query("lang") lang: String): Response<Weather>
}