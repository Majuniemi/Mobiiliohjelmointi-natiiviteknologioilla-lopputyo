package com.example.grade_five.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grade_five.viewmodel.GradeFiveState
import com.example.grade_five.viewmodel.GradeFiveViewModel
import coil.compose.AsyncImage


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
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
                ) {
                when (gradeFiveState) {
                    is GradeFiveState.Loading -> {
                        Column {
                            Spacer(modifier = Modifier.height(32.dp))
                            CircularProgressIndicator()
                        }
                    }
                    is GradeFiveState.Success -> {
                        val joke = (gradeFiveState as GradeFiveState.Success).joke
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(32.dp)
                                .background(MaterialTheme.colorScheme.secondaryContainer)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                AsyncImage(
                                    model = joke.iconUrl,
                                    contentDescription = "Chuck Norris Icon",
                                    modifier = Modifier.size(64.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    style = MaterialTheme.typography.headlineSmall,
                                    text = "Joke of the day"
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    style = MaterialTheme.typography.bodyLarge,
                                    text = joke.value,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Column {
                                Button(
                                    onClick = { viewModel.getJoke() },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondary
                                    )
                                ) { Text("Get new joke") }
                            }

                        }
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
