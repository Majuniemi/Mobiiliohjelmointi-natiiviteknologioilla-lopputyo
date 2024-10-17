package com.example.grade_five.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            ScreenTopBar("Info", navController)
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                item {
                    Text(style = MaterialTheme.typography.headlineSmall,
                        text = "Mobile programming with native technologies.\n")
                }
                item {
                    Text(style = MaterialTheme.typography.bodyLarge,
                        text = "My app uses a free API, which gives a random Chuck Norris joke as a JSON object. \n")
                }
                item {
                    Text(style = MaterialTheme.typography.bodySmall,
                        text = "The app has two screens: main and info. Main screen displays a random joke and info screen has information about the app.\n\n")
                }
                item {
                    Text(style = MaterialTheme.typography.bodyLarge,
                        text = "Requirements for the app for grade 5 is as follows:\n")
                }
                item {
                    Text(style = MaterialTheme.typography.bodySmall,
                        text = "- App contains some software logic. It could be, for example, performing some calculation " +
                                "or retrieving (simple) data from API (like in Todos example)." +
                                "In case API has parameters, you can hardcode them (e.g., coordinate to weather API in case you choose the do the app based on example app)\n\n" +
                                "- ViewModel class must be implemented for holding state and functionality for UI (composables)\n\n" +
                                "- UI needs to suitable for mobile app. Modify theme (e.g., colors) so your app does not use default values.\n\n" +
                                "- All the strings should be saved under resource file.\n\n" +
                                "- Implement navigation and a simple screen (e.g., info screen). App must have at" +
                                "least two screens (main and info).\n\n" +
                                "- App must use API service and display data retrieved from the service.\n\n" +
                                "- App must implement MVVM architecture.\n\n" +
                                "- Code is divided into separate files and packages.\n\n" +
                                "- Possible errors are handled (e.g., if API does not return anything or there is an error, a message is displayed).\n\n" +
                                "- When data is loaded on the background, a message (or spinner) is displayed to the user on UI.\n\n" +
                                "App for grade 5 may contain also following features:\n" +
                                "- Displaying an image (using Coil library)."
                    )
                }
            }
        }
    )
}
