package com.example.mvvm_retrofit.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvm_retrofit.network.model.Location
import com.example.mvvm_retrofit.repository.SearchActivityReposotory

class SearchActivityViewModel(application: Application) : AndroidViewModel(application){
    private val repository = SearchActivityReposotory(application)
    val shoProgress : LiveData<Boolean>
    val locationList : LiveData<List<Location>>

    init {
        this.shoProgress = repository.showProgress
        this.locationList = repository.locationList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchLocation(lication : String){
        repository.searchLocation(lication)
    }

}