package com.example.randomjokes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomjokes.data.repository.JokeRepository
import com.example.randomjokes.data.response.JokeResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class JokeViewModel(private val repository: JokeRepository) : ViewModel(){

    private val _joke= MutableLiveData<Response<JokeResponse>>()
    val joke:LiveData<Response<JokeResponse>> get() = _joke

    fun getRandomJoke(){
        viewModelScope.launch {
            _joke.value= repository.getJokes()
        }
    }

}