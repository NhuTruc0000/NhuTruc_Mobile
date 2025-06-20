package com.example.baitapvenha06_01.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import com.example.baitapvenha06_01.viewmodel.TaskViewModel

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object TaskList : BottomNavItem("task_list", Icons.Default.List, "Công việc")
    object Add : BottomNavItem("add_task", Icons.Default.AddCircle, "Thêm")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Hồ sơ")
}

@Composable
fun MainScreen(viewModel: TaskViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "smart_home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("smart_home") {
                SmartTaskHomeScreen(viewModel)
            }

            composable(BottomNavItem.TaskList.route) {
                TaskListScreen(viewModel)
            }
            composable(BottomNavItem.Add.route) {
                AddTaskScreen(viewModel)
            }
            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.TaskList,
        BottomNavItem.Add,
        BottomNavItem.Profile
    )
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
