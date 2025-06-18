package com.example.thuchanh05_01

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thuchanh05_01.FirebaseAuthSuccessScreen

object Routes {
    const val LOGIN_SCREEN = "login_screen"
    const val AUTH_ERROR_SCREEN = "auth_error_screen"
    const val AUTH_SUCCESS_SCREEN = "auth_success_screen"
}


@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
        composable(Routes.LOGIN_SCREEN) {
            BeginScreen(navController = navController)
        }
        composable(Routes.AUTH_ERROR_SCREEN) {
            FirebaseAuthErrorScreen(navController = navController)
        }
        composable(Routes.AUTH_SUCCESS_SCREEN) {
            FirebaseAuthSuccessScreen(navController = navController)
        }
    }
}