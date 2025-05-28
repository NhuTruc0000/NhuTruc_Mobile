package com.example.thuchanh02_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuchanh02_3.ui.theme.Thuchanh023Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Thuchanh023Theme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    IntroScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

private fun MainActivity.Scaffold(modifier: Modifier, function: @Composable Any) {
    TODO("Not yet implemented")
}

@Composable
fun IntroScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tên người dùng
        Text("Nguyễn Văn A", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("2342312323", fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        // Logo Jetpack Compose
        Image(
            painter = painterResource(id = R.drawable.ic_jetpack_compose),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tiêu đề và mô tả
        Text("Jetpack Compose", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 14.sp,
            color = Color.DarkGray,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Nút bấm
        Button(
            onClick = { /* TODO: Chuyển màn hình hoặc xử lý gì đó */ },
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text("I'm ready")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Thuchanh023Theme {
        IntroScreen()
    }

}