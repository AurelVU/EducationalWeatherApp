package ru.vsu.educational_weather_app.features.weather.models

import java.time.LocalDateTime

data class Current(
    val cloud: Int,
    val condition: Condition,
    val dewpointC: Double,
    val dewpointF: Double,
    val feelslikeC: Double,
    val feelslikeF: Double,
    val gustKph: Double,
    val gustMph: Double,
    val heatindexC: Double,
    val heatindexF: Double,
    val humidity: Int,
    val isDay: Int,
    val lastUpdated: LocalDateTime,
    val lastUpdatedEpoch: Int,
    val precipIn: Int,
    val precipMm: Int,
    val pressureIn: Double,
    val pressureMb: Int,
    val tempC: Double,
    val tempF: Double,
    val uv: Double,
    val visKm: Int,
    val visMiles: Int,
    val windDegree: Int,
    val windDir: String,
    val windKph: Double,
    val windMph: Double,
    val windchillC: Double,
    val windchillF: Double
)