package com.example.grade_five.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScaffoldNavigationApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Main"
    ) {
        composable(route = "Main") {
            MainScreen(navController)
        }
        composable("info") {
            InfoScreen(navController)
        }
    }
}
