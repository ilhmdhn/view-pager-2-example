package com.ilhmdhn.imageslider.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        fun getApiService(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.rawg.io/api/games/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}