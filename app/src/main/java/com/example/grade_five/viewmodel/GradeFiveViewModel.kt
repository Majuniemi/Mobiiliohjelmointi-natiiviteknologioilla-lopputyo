package com.example.grade_five.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grade_five.model.Joke
import com.example.grade_five.model.JokesApi
import kotlinx.coroutines.launch


sealed interface GradeFiveState {
    data class Success(val joke: Joke) : GradeFiveState
    object Loading : GradeFiveState
    object Error : GradeFiveState
}

class GradeFiveViewModel: ViewModel() {
    var gradeFiveState: GradeFiveState by mutableStateOf<GradeFiveState>(GradeFiveState.Loading)
        private set

    init {
        getJoke()
    }

    fun getJoke() {
        viewModelScope.launch {
            var jokesApi: JokesApi? = null
            try {
                jokesApi = JokesApi.getInstance()
                val joke = jokesApi.getJokes()
                Log.d("VIEWMODEL", "Fetched joke: ${joke.value}")
                gradeFiveState = GradeFiveState.Success(joke)
            } catch (e: Exception) {
                Log.e("VIEWMODEL", "Error fetching joke: ${e.message}", e)
                gradeFiveState = GradeFiveState.Error
            }
        }
    }
}