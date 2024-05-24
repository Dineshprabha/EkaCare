package com.dineshprabha.ekacare

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dineshprabha.ekacare.data.local.AppDatabase
import com.dineshprabha.ekacare.data.local.UserDao
import com.dineshprabha.ekacare.data.model.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var appDatabase: AppDatabase
    lateinit var userDao: UserDao

    @Before
    fun setUp(){
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = appDatabase.userDao()
    }

    @Test
    fun insertUser_expectedSingleUser() = runBlocking{
        val user = User(0,"Jay", 30, "01/01/1990", "123 Street")
        userDao.insertUser(user)

        val result = userDao.getAllUsers()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("Jay", result[0].name)
        Assert.assertEquals(30, result[0].age)
        Assert.assertEquals("01/01/1990", result[0].dob)
        Assert.assertEquals("123 Street", result[0].address)
    }

    @Test
    fun deleteUser_expectedNoResults() = runBlocking {
        val user = User(0,"Jay", 30, "01/01/1990", "123 Street")
        userDao.insertUser(user)

        userDao.delete()

        val result = userDao.getAllUsers()
        Assert.assertEquals(0, result.size)

    }

    @After
    fun tearDown(){
        appDatabase.close()
    }
}