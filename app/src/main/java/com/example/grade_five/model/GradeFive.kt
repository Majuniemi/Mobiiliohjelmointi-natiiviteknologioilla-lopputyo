package com.example.grade_five.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Success(val value: String)

data class Joke(
    val icon_url: String,
    val id: String,
    val url: String,
    val value: String
)

const val BASE_URL = "https://api.chucknorris.io/jokes/"
    interface JokesApi {
    @GET("random")
    suspend fun getJokes(): Joke

    companion object {
        var jokeService: JokesApi? = null

        fun getInstance(): JokesApi {
            if (jokeService === null) {
                jokeService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(JokesApi::class.java)
            }
            return jokeService!!
        }
    }
}