package com.example.disense.app

import android.app.Application
import com.example.disense.di.AppComponent
import com.example.disense.di.AppModule
import com.example.disense.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}