package com.natesh.whatherapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.natesh.whatherapp.model.Weatherdata
import com.natesh.whatherapp.repostary.MainRepository


class MainActivityViewModel(application: Application) : AndroidViewModel(application)  {

 //  private val context = getApplication<Application>().applicationContext


    val  repository = MainRepository(application)

    val ShowProgress : LiveData<Boolean>

    val locationList : LiveData<List<Weatherdata>>


    init{

        this.ShowProgress = repository.showProgress
        this.locationList = repository.LocationList
    }

    fun changestateProgress(){

        repository.changeprogressstate()
    }


    fun SearchLocation(searchString : String){

        repository.SearchLocation(searchString)
    }


}