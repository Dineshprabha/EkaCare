package com.dineshprabha.ekacare.di

import android.app.Application
import androidx.room.Room
import com.dineshprabha.ekacare.data.local.AppDatabase
import com.dineshprabha.ekacare.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app:Application): AppDatabase{
        return Room.databaseBuilder(app, AppDatabase::class.java, "user.db")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase): UserDao{
        return db.userDao()
    }
}