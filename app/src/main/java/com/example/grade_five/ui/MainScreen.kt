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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grade_five.viewmodel.GradeFiveState
import com.example.grade_five.viewmodel.GradeFiveViewModel
import coil.compose.AsyncImage
import com.example.grade_five.R


@Composable
fun MainScreen(
    navController: NavController,
    viewModel: GradeFiveViewModel = viewModel()
) {
    val gradeFiveState = viewModel.gradeFiveState

    Scaffold(
        topBar = {
            MainTopBar(stringResource(R.string.topbar_app_name), navController)
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
                                .padding(16.dp)
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
                                    contentDescription = stringResource(R.string.image_content_description),
                                    modifier = Modifier.size(64.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    style = MaterialTheme.typography.headlineSmall,
                                    text = stringResource(R.string.main_screen_header)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    style = MaterialTheme.typography.bodyMedium,
                                    text = joke.value,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth(0.7f)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                    is GradeFiveState.Error -> {
                        Text(
                            style = MaterialTheme.typography.bodyLarge,
                            text = stringResource(R.string.fetching_joke_error_message),
                            modifier = Modifier.padding(16.dp),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { viewModel.getJoke() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp),
                    shape = MaterialTheme.shapes.extraSmall
                ) {
                    Text(
                        stringResource(R.string.get_a_new_joke_button),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    )
}
