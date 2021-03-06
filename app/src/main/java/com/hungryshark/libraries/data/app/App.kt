package com.hungryshark.libraries.data.app

import android.app.Application
import com.hungryshark.libraries.presentation.di.AppComponent
import com.hungryshark.libraries.presentation.di.AppModule
import com.hungryshark.libraries.presentation.di.DaggerAppComponent


class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}