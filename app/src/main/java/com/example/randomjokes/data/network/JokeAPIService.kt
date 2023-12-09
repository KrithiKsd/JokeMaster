package com.example.randomjokes.data.network

import com.example.randomjokes.data.response.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeAPIService {

    @GET(value = "/random_joke")
    suspend fun getJokes(): Response<JokeResponse>
}