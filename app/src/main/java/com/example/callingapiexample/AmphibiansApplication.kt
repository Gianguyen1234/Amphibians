package com.example.callingapiexample

import android.app.Application
import com.example.callingapiexample.data.AppContainer
import com.example.callingapiexample.data.DefaultContainer

class AmphibiansApplication: Application(){

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer()
    }
}