package com.hungryshark.libraries.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hungryshark.libraries.data.data.room.UserDao

@Database(
    entities = [
        User::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}