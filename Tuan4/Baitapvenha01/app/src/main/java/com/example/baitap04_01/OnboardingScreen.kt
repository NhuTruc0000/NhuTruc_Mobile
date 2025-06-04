package com.example.baitap04_01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController


@Composable
fun OnboardingScreen(
    navController: NavController,

) {
    val viewModel: OnboardingViewModel = viewModel()

    val page = OnboardingData.pages[viewModel.currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip button góc trên bên phải
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { viewModel.skip() }) {
                Text("Skip")
            }
        }

        // Phần nội dung chính: ảnh, title, description
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = page.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = page.description,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        // Điều hướng: Back và Next/Get Started
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (viewModel.currentPage > 0) {
                Button(onClick = { viewModel.previousPage() }) {
                    Text("Back")
                }
            } else {
                Spacer(modifier = Modifier.width(80.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (viewModel.currentPage < OnboardingData.pages.lastIndex) {
                        viewModel.nextPage()
                    } else {
                        navController.navigate("home")
                    }
                }
            ) {
                Text(if (viewModel.currentPage < OnboardingData.pages.lastIndex) "Next" else "Get Started")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    val navController = rememberNavController() // Tạo NavController tạm
    OnboardingScreen(navController)
}
