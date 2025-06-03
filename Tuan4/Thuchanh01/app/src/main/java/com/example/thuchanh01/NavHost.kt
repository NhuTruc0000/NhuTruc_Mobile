package com.example.thuchanh01

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thuchanh01.DetailScreen
import com.example.thuchanh01.MainScreen

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(onNavigate = {
                navController.navigate("list")
            })
        }
        composable("list") {
            ListScreen(onItemClick = { quote ->
                navController.navigate("detail/${quote}")
            })
        }
        composable(
            route = "detail/{quote}",
            arguments = listOf(navArgument("quote") { type = NavType.StringType })
        ) { backStackEntry ->
            val quote = backStackEntry.arguments?.getString("quote") ?: ""
            DetailScreen(quote = quote, onBack = {
                navController.popBackStack("main", inclusive = false)
            })
        }
    }
}


