package com.example.mvvm_weather_retrofit.network

import com.example.mvvm_weather_retrofit.network.model.Location
import com.example.mvvm_weather_retrofit.network.model.WeatherResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://www.metaweather.com/api/location/"

object RetrofitRepo{

    //Creat Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //Create OkHttp Client
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

    //Create Retrofit Builder
    private val retrofitCall = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())

    //Create Retrofit Instance
    private val retrofitBuilder = retrofitCall.build()

    //Create Generic Type Function For Interface Class
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofitBuilder.create(serviceType)
    }
}

interface WeatherNetwork {

    @GET("search")
    fun getLocaton(@Query("query") searchString: String) : Call<List<Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid") woeid : Int) : Call<WeatherResponse>
}