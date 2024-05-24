package com.dineshprabha.ekacare.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dineshprabha.ekacare.data.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
