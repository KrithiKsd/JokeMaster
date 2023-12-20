package com.example.randomjokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.randomjokes.databinding.ActivityMainBinding
import com.example.randomjokes.ui.JokeViewModel
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isSelected = false
    private lateinit var punchLine: String

    private lateinit var viewModel: JokeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myApplication = application as MyApplication
        viewModel = JokeViewModel(myApplication.appContainer.jokeRepo)

        Glide.with(this).load(R.drawable.laugh_gif).into(binding.imageView)

        binding.btnGuess.setOnClickListener {
            if(isSelected){
                binding.btnGuess.text = resources.getText(R.string.label_once_again)
                binding.tvJokeQuestion.text= punchLine
                isSelected=false

            }else{
                viewModel.getRandomJoke()
                isSelected=true
                binding.btnGuess.text =resources.getText(R.string.label_guess)
            }
        }

        viewModel.joke.observe(this, Observer {
          joke->binding.tvJokeQuestion.text= joke.body()?.setup
            punchLine= joke.body()?.punchline.toString()
        })

    }
}