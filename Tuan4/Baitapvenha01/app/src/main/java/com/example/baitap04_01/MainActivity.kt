package com.example.baitap04_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.baitap04_01.ui.theme.Baitap0401Theme
import com.example.baitap04_01.OnboardingScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Baitap0401Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "onboarding") {
        composable("onboarding") { OnboardingScreen(navController) }
        composable("home") { HomeScreen() }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavHost(navController)
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Welcome to UTH SmartTasks!")
    }
}
