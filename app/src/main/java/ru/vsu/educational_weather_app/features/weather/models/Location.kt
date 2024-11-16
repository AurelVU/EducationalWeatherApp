package ru.vsu.educational_weather_app.features.weather.models

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtimeEpoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tzId: String
)