package com.example.baitap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft // Tự động lật cho RTL
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitap.ui.theme.BaiTapTheme

// Màu sắc sử dụng
val topBarBlueColor = Color(0xFF007AFF)
val lightBlueBoxColor = Color(0xFFCADDFF)
val mediumBlueBoxColor = Color(0xFF6EA3FF)
val screenBackgroundColor = Color.White
val itemContainerBackgroundColor = Color(0xFFF0F2F5)

class RowLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapTheme {
                RowLayoutScreen(onBack = {})
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RowLayoutScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Row Layout",
                        color = topBarBlueColor,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    Text(
                        text = "< Back",
                        color = Color.Blue,
                        modifier = Modifier
                            .clickable { onBack() }
                            .padding(bottom = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = screenBackgroundColor
                )
            )
        },
        containerColor = screenBackgroundColor
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(itemContainerBackgroundColor, RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    repeat(4) {
                        ItemRow()
                    }
                }
            }
        }
    }
}

@Composable
fun ItemRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ColorBoxItem(color = lightBlueBoxColor, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(12.dp))
        ColorBoxItem(color = mediumBlueBoxColor, modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(12.dp))
        ColorBoxItem(color = lightBlueBoxColor, modifier = Modifier.weight(1f))
    }
}

@Composable
fun ColorBoxItem(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(55.dp)
            .clip(RoundedCornerShape(8.dp)) // Bo góc
            .background(color)
    )

}


@Preview(showBackground = true, widthDp = 375, heightDp = 812) // Kích thước giống iPhone
@Composable
fun RowLayoutScreenPreview() {
    BaiTapTheme {
        RowLayoutScreen(onBack = {})
    }
}

// Bạn cần định nghĩa Theme cho ứng dụng, ví dụ (nếu chưa có):
@Composable
fun BaiTapTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme( // Sử dụng lightColorScheme cho nền sáng
            primary = topBarBlueColor,
            background = screenBackgroundColor,
            surface = screenBackgroundColor,
            // ... các màu khác nếu cần
        ),
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}