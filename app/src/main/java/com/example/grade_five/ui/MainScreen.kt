package com.example.grade_five.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar("Chuck Norris Jokes", navController)
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    text = "Content for home screen"
                )
            }
        }
    )
}
