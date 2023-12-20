package com.example.randomjokes.data.repository

import com.example.randomjokes.data.network.JokeAPIService
import com.example.randomjokes.data.response.JokeResponse
import retrofit2.Response

class JokeRepository (private val api: JokeAPIService) {

    suspend fun getJokes(): Response<JokeResponse>{
        return api.getJokes()
    }

}