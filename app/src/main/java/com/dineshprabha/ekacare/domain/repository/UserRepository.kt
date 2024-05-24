package com.dineshprabha.ekacare.domain.repository

import com.dineshprabha.ekacare.data.local.UserDao
import com.dineshprabha.ekacare.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

    suspend fun getAllUsers(): List<User>{
        return userDao.getAllUsers()
    }


}