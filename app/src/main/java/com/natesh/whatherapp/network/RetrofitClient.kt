package com.natesh.whatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val BASE_URL = "https://www.metaweather.com/api/location/"
    private var retrofit: Retrofit? = null

    val service: WeatherNetwork
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create<WeatherNetwork>(WeatherNetwork::class.java!!)
        }
}