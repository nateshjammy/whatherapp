package com.natesh.whatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.natesh.whatherapp.model.WeatherResponse
import com.natesh.whatherapp.repostary.DetailsRepositary

class DetailsActivityViewModel (application: Application) : AndroidViewModel(application) {

  private  val  repositary = DetailsRepositary(application)
    val showProcess : LiveData<Boolean>
    val response  : LiveData<WeatherResponse>

    init {
        showProcess = repositary.showProcess
        response = repositary.response
    }


    fun getweather(woied: Int){

        repositary.getweather(woied)
    }
}