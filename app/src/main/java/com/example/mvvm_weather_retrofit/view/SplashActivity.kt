package com.example.mvvm_weather_retrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mvvm_weather_retrofit.R.layout.activity_splash

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_splash)

        //this is splash screen and this splash screen will remain only 2 seconds
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                startActivity(Intent(this, SearchActivity::class.java))
                finish()
            },2000)
        }

    }
}
