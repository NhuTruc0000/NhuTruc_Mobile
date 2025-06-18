package com.example.baitapvenha05_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baitapvenha05_02.ui.theme.Baitapvenha0502Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Baitapvenha0502Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ProductDetailScreen(onBackClick = {}) // Gọi hàm ở đây
                }
            }
        }
    }
}

