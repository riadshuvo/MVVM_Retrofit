package com.example.mvvm_weather_retrofit.network.model

 data class WeatherResponse(
    val consolidated_weather: List<ConsolidatedWeather>,
    val sun_rise: String,
    val sun_set: String,
    val time: String,
    val title: String,
    val woeid: Int
)