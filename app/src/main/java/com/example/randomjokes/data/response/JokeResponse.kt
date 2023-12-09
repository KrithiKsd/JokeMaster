package com.example.randomjokes.data.response

data class JokeResponse(
    val id: Int,
    val punchline: String,
    val setup: String,
    val type: String
)