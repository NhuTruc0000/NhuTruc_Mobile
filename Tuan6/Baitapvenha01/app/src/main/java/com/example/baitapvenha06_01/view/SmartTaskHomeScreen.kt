package com.example.baitapvenha06_01.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.baitapvenha06_01.R
import androidx.compose.ui.unit.dp
import com.example.baitapvenha06_01.model.Task  // Đảm bảo đúng package của class Task
import com.example.baitapvenha06_01.viewmodel.TaskViewModel


@Composable
fun SmartTaskHomeScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.uth_logo), // Thêm hình logo vào drawable
                contentDescription = "UTH Logo",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("SmartTasks", style = MaterialTheme.typography.headlineSmall)
                Text("A simple and efficient to-do app", style = MaterialTheme.typography.bodySmall)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tasks) { task ->
                SmartTaskCard(task = task)
            }
        }
    }
}

@Composable
fun SmartTaskCard(task: Task) {
    val bgColor = when (task.status) {
        "In Progress" -> Color(0xFFF8BBD0)
        "Pending" -> Color(0xFFB2DFDB)
        else -> Color(0xFFFFFFFF)
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = bgColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(task.title, style = MaterialTheme.typography.titleMedium)
            Text(task.description)
            Text("Status: ${task.status}", color = Color.DarkGray)
            Text(task.time, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SmartTaskCardPreview() {
    val sampleTask = Task(
        id = 1,
        title = "Làm bài tập Compose",
        description = "Hoàn thành UI MVVM",
        status = "In Progress",
        time = "14:30 15/06/2025"
    )

    SmartTaskCard(task = sampleTask)
}


