package com.example.mvvm_retrofit.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ConsolidatedWeather(
    @PrimaryKey val id: Long,
    val the_temp: Double
)