package com.hungryshark.libraries.presentation.di

import com.hungryshark.libraries.data.app.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app1: App) {

    @Provides
    fun app(): App = app1
}