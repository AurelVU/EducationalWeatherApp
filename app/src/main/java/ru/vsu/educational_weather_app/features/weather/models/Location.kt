package ru.vsu.educational_weather_app.features.weather.models

import java.time.LocalDateTime

data class Location(
    val country: String,
    val lat: Double,
    val localtime: LocalDateTime,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
)