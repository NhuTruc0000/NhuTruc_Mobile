package com.example.baitap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.baitap.ui.theme.BaiTapTheme
import kotlin.collections.*
import kotlin.collections.mutableListOf
import kotlin.collections.last
import kotlin.collections.removeLast // Có thể cần nếu IDE yêu cầu rõ
import androidx.compose.runtime.mutableStateListOf




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaiTapTheme {


                val screenStack = remember { mutableStateListOf("welcome") }
                val currentScreen = screenStack.last()

                when (currentScreen) {
                    "welcome" -> WelcomeScreen(
                        onReadyClick = { screenStack.add("list") }
                    )

                    "list" -> UIComponentsListScreen(
                        onComponentClick = { component ->
                            when (component) {
                                "Text" -> screenStack.add("textDetail")
                                "Image" -> screenStack.add("imageDetail")
                                "TextField" -> screenStack.add("textFieldDetail")
                                "Column" -> screenStack.add("ColumnLayoutScreen")
                                "Row" -> screenStack.add("RowLayoutScreen")
                            }
                        },
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )

                    "textDetail" -> TextDetailScreen(
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )

                    "imageDetail" -> ImageScreen(
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )
                    "ColumnLayoutScreen" -> ColumnLayoutScreen(
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )
                    "RowLayoutScreen" -> RowLayoutScreen(
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )
                    "textFieldDetail" -> TextFieldScreen(
                        onBack = {
                            if (screenStack.size > 1) screenStack.removeAt(screenStack.size - 1)
                        }
                    )

                }
            }
        }
    }
}


