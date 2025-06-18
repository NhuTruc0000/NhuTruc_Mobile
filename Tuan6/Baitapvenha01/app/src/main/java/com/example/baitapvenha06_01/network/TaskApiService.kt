package com.example.baitapvenha06_01.network

import com.example.baitapvenha06_01.model.Task
import retrofit2.http.GET
import retrofit2.http.DELETE
import retrofit2.http.Path

interface TaskApiService {
    @GET("researchUTH/tasks")
    suspend fun getTasks(): List<Task>

    @DELETE("researchUTH/task/{id}")
    suspend fun deleteTask(@Path("id") id: Int)
}