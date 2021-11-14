package com.hungryshark.libraries.presentation.di

import androidx.room.Room
import com.hungryshark.libraries.data.app.App
import com.hungryshark.libraries.data.room.UserDao
import com.hungryshark.libraries.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun database(app: App): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "gb-libs.db"
    ).build()

    @Provides
    @Singleton
    fun userDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}