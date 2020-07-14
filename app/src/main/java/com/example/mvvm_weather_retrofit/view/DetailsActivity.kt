package com.example.mvvm_weather_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_weather_retrofit.R
import com.example.mvvm_weather_retrofit.viewModel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel : DetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel = ViewModelProvider(this).get(DetailsActivityViewModel::class.java)

        if(intent.hasExtra("name")){
            tv_location.text = intent.getStringExtra("name")
        }

        //

        if(intent.hasExtra("Location")){
            //Do network call
            val locationId = intent.getIntExtra("Location",0)
            if( locationId > 0)
            viewModel.getWeather(locationId)
        }

        viewModel.showProgressBar.observe(this, Observer {
            if (it) {
                details_progress.visibility = View.VISIBLE
            } else {
                details_progress.visibility = View.GONE
            }
        })

        viewModel.response.observe(this, Observer {
            if (it != null){
                val temp = it.consolidated_weather[0].the_temp
                tv_temp.text = String.format("%.2f", temp).toDouble().toString()
            }
        })

    }
}
