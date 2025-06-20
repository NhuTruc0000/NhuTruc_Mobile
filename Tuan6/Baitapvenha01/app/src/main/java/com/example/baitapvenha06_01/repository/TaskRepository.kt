package com.example.baitapvenha06_01.repository

import com.example.baitapvenha06_01.model.Task
import com.example.baitapvenha06_01.network.RetrofitInstance

class TaskRepository {
    suspend fun getTasks(): List<Task> {
        return RetrofitInstance.api.getTasks()
    }

    suspend fun deleteTask(id: Int) {
        RetrofitInstance.api.deleteTask(id)
    }
}