package com.example.baitapvenha06_01.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.baitapvenha06_01.model.Task
import com.example.baitapvenha06_01.viewmodel.TaskViewModel
import androidx.compose.material3.CenterAlignedTopAppBar



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("List", style = MaterialTheme.typography.headlineSmall)
                },
                navigationIcon = {  
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(36.dp)
                            .background(Color(0xFF00AEEF), shape = CircleShape)
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(36.dp)
                            .background(Color.Red, shape = CircleShape)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
                    }
                }
            )

        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(tasks) { task ->
                val bgColor = when (task.status) {
                    "In Progress" -> Color(0xFFF8BBD0) // Hồng nhạt
                    "Pending" -> Color(0xFFC8E6C9)     // Xanh lá nhạt
                    else -> Color(0xFFFFCDD2)          // Đỏ nhạt (Done hoặc khác)
                }

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = bgColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(task.title, style = MaterialTheme.typography.titleMedium)
                        Text(task.description, style = MaterialTheme.typography.bodyMedium)
                        Text(task.time, style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}
