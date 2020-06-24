package com.natesh.whatherapp.network

import com.natesh.whatherapp.model.WeatherResponse
import com.natesh.whatherapp.model.Weatherdata
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//const  val BASE_URL   = "https://www.metaweather.com/api/location/"

interface WeatherNetwork {

   @GET("search?")
    fun getLocation(@Query("query")serachString : String) : Call<List<Weatherdata>>

    @GET("{woeid}")
    fun getweather(@Path("woeid")woeid : Int) : Call<WeatherResponse>

}