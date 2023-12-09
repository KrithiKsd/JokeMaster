package com.example.randomjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.example.randomjokes.data.network.JokeAPIService
import com.example.randomjokes.data.network.RetrofitInstance
import com.example.randomjokes.data.response.JokeResponse
import com.example.randomjokes.databinding.ActivityMainBinding
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: JokeAPIService
    private var isSelected = false
    private lateinit var punchLine: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.laugh_gif).into(binding.imageView)

        retService= RetrofitInstance.getRetrofitInstance().create(JokeAPIService::class.java)


        binding.btnGuess.setOnClickListener {
            if(isSelected){
                binding.btnGuess.text ="Once Again!"
                binding.tvJokeQuestion.text= punchLine
                isSelected=false

            }else{
                getJokes()
                isSelected=true
                binding.btnGuess.text ="Guess!"
            }
        }

    }

    private fun getJokes() {
        val responseLiveData:LiveData<Response<JokeResponse>> = liveData {
            val response= retService.getJokes()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val data= it.body()
            if(data!=null){
                binding.tvJokeQuestion.text = data.setup
                punchLine=data.punchline

            }


        })
    }
}