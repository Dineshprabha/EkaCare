package com.dineshprabha.ekacare.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.dineshprabha.ekacare.data.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("DELETE From users")
    suspend fun delete()

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

}