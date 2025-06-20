package com.example.baitapvenha06_01.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: TaskApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://amock.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TaskApiService::class.java)
    }
}