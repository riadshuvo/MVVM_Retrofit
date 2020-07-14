package com.example.mvvm_weather_retrofit.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_weather_retrofit.network.BASE_URL
import com.example.mvvm_weather_retrofit.network.RetrofitRepo
import com.example.mvvm_weather_retrofit.network.WeatherNetwork
import com.example.mvvm_weather_retrofit.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsActivityReposotory(val application: Application) {

    val showProgressBar = MutableLiveData<Boolean>()
    val response = MutableLiveData<WeatherResponse>()
    var lastRequestTime : Long = -1

    fun getWeather(woeid: Int) {

        //check if the device roted between 10 seconds, if so, then it will call the api again
        if(System.currentTimeMillis() - lastRequestTime < 10000){
            return
        }

        showProgressBar.value = true

        //network call
        val weatherRetrofitService = RetrofitRepo.buildService(WeatherNetwork::class.java)

        val getWeatherWeid = weatherRetrofitService.getWeather(woeid)

        getWeatherWeid.enqueue(object : Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
               showProgressBar.value = false
                Toast.makeText(application,"error message: ${t.message}", Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                resp: Response<WeatherResponse>
            ) {
                lastRequestTime = System.currentTimeMillis()
                response.value = resp.body()
                showProgressBar.value = false
            }

        })
    }
}