package com.example.grade_five.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grade_five.viewmodel.GradeFiveState
import com.example.grade_five.viewmodel.GradeFiveViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: GradeFiveViewModel = viewModel()
) {
    val gradeFiveState = viewModel.gradeFiveState

    Scaffold(
        topBar = {
            MainTopBar("Chuck Norris Jokes", navController)
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (gradeFiveState) {
                    is GradeFiveState.Loading -> {
                        CircularProgressIndicator()
                    }
                    is GradeFiveState.Success -> {
                        val joke = (gradeFiveState as GradeFiveState.Success).joke
                        Text(text = joke.value)
                    }
                    is GradeFiveState.Error -> {
                        Text(
                            style = MaterialTheme.typography.bodyLarge,
                            text = "Error fetching joke"
                        )
                    }
                }
            }
        }
    )
}
