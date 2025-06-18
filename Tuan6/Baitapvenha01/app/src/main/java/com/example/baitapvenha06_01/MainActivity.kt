package com.example.baitapvenha06_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.CompositionLocalProvider

import com.example.baitapvenha06_01.ui.theme.Baitapvenha0601Theme
import com.example.baitapvenha06_01.viewmodel.TaskViewModel
import com.example.baitapvenha06_01.view.MainScreen
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.baitapvenha06_01.repository.TaskRepository
import com.example.baitapvenha06_01.TaskViewModelFactory
import com.example.baitapvenha06_01.network.RetrofitInstance

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Tạo repository và factory
        val repository = TaskRepository()
        val factory = TaskViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)



        setContent {
            Baitapvenha0601Theme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF00AEEF)
                )
            ) {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

