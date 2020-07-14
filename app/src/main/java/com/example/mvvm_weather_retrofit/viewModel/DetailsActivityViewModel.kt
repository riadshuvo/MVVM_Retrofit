package com.example.mvvm_weather_retrofit.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvm_weather_retrofit.network.model.WeatherResponse
import com.example.mvvm_weather_retrofit.repository.DetailsActivityReposotory

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val reposotory = DetailsActivityReposotory(application)

    val showProgressBar : LiveData<Boolean>
    val response : LiveData<WeatherResponse>

    init {
        this.showProgressBar = reposotory.showProgressBar
        this.response = reposotory.response
    }

    fun getWeather(weoid: Int){
        reposotory.getWeather(weoid)
    }

}