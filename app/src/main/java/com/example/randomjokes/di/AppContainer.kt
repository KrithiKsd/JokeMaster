package com.example.randomjokes.di

import com.example.randomjokes.data.network.JokeAPIService
import com.example.randomjokes.data.network.RetrofitInstance
import com.example.randomjokes.data.repository.JokeRepository

class AppContainer {
    private val api=RetrofitInstance.getRetrofitInstance().create(JokeAPIService::class.java)
    val jokeRepo=JokeRepository(api)
}