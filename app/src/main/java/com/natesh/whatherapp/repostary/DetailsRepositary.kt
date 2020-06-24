package com.natesh.whatherapp.repostary

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.natesh.whatherapp.model.WeatherResponse
import com.natesh.whatherapp.model.Weatherdata
import com.natesh.whatherapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsRepositary(val application: Application) {


    val showProcess = MutableLiveData<Boolean>()
    val response  = MutableLiveData<WeatherResponse>()

    ///ini Retrofit Class
    val userDataService = RetrofitClient.service

    fun getweather(woied : Int){

        showProcess.value = true


        val service = userDataService.getweather(woied)

        service.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                showProcess.value = false
                Toast.makeText(application, "api failiure", Toast.LENGTH_SHORT).show()

            }
            override fun onResponse(
                call: Call<WeatherResponse>,
                resp: Response<WeatherResponse>
            ) {
                response.value = resp.body()
                showProcess.value = false
            }

        })



    }

}