package com.example.cryptocoins

import android.app.Application
import com.example.cryptocoins.repository.classes.DefaultAppContainer
import com.example.cryptocoins.repository.interfaces.AppContainer

class CoinsApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}