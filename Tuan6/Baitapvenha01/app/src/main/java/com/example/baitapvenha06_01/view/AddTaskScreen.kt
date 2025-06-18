package com.example.baitapvenha06_01.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.baitapvenha06_01.model.Task
import com.example.baitapvenha06_01.viewmodel.TaskViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AddTaskScreen(viewModel: TaskViewModel) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Thêm công việc", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Tiêu đề") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        OutlinedTextField(
            value = desc,
            onValueChange = { desc = it },
            label = { Text("Mô tả") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            shape = RoundedCornerShape(12.dp)
        )

        Button(
            onClick = {
                if (title.isNotBlank()) {
                    val task = Task(
                        id = (1000..9999).random(),
                        title = title,
                        description = desc,
                        status = "Pending",
                        time = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault()).format(Date())
                    )
                    viewModel.addTask(task)
                    title = ""
                    desc = ""
                }
            },
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Thêm")
        }
    }
}