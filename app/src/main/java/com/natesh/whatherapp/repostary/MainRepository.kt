package com.natesh.whatherapp.repostary

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.natesh.whatherapp.model.Weatherdata
import com.natesh.whatherapp.network.RetrofitClient
import com.natesh.whatherapp.viewmodel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository(val application: Application) {


    val showProgress = MutableLiveData<Boolean>()

    val LocationList = MutableLiveData<List<Weatherdata>>()

    ///ini Retrofit Class
    val userDataService = RetrofitClient.service

    fun changeprogressstate(){

        showProgress.value = !(showProgress.value != null && showProgress.value !!)

    }

    fun SearchLocation(searchString : String){
        showProgress.value = true

        ///call the API that define In Interface
        val service = userDataService.getLocation(searchString)

        service.enqueue(object : Callback<List<Weatherdata>> {
            override fun onFailure(call: Call<List<Weatherdata>>, t: Throwable) {
                showProgress.value = false

               Toast.makeText(application, "api failiure", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Weatherdata>>,
                response: Response<List<Weatherdata>>
            ) {
                Log.d("Responseapi","Response : ${Gson().toJson(response.body())}")
                LocationList.value = response.body()
                showProgress.value = false


            }

        })



    }

}