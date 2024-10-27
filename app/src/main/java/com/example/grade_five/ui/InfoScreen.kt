package com.example.grade_five.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import com.example.grade_five.R

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            ScreenTopBar(stringResource(R.string.info_screen_topbar_header), navController)
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                style = MaterialTheme.typography.headlineSmall,
                                text = stringResource(R.string.course_name),
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                style = MaterialTheme.typography.bodyLarge,
                                text = stringResource(R.string.info_header_1)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                style = MaterialTheme.typography.bodySmall,
                                text = stringResource(R.string.app_description)
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                style = MaterialTheme.typography.bodyLarge,
                                text = stringResource(R.string.requirements_header)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                style = MaterialTheme.typography.bodySmall,
                                text = stringResource(R.string.app_requirements)
                            )
                        }
                    }
                }
            }
        }
    )
}
