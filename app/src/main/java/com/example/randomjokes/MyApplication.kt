package com.example.randomjokes

import android.app.Application
import com.example.randomjokes.di.AppContainer

class MyApplication: Application() {
    lateinit var appContainer: AppContainer
    private set

    override fun onCreate() {
        super.onCreate()

        appContainer= AppContainer()
    }
}