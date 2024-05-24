//package com.dineshprabha.ekacare
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.dineshprabha.ekacare.data.local.AppDatabase
//import com.dineshprabha.ekacare.data.local.UserDao
//import com.dineshprabha.ekacare.data.model.User
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import kotlinx.coroutines.test.runTest
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import javax.inject.Inject
//
//@HiltAndroidTest
//class EkaCareTest {
//
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    @get:Rule
//    val hiltAndroidRule = HiltAndroidRule(this)
//
//    @Inject
//    lateinit var appDatabase: AppDatabase
//    private lateinit var userDao: UserDao
//
//    @Before
//    fun setUp() {
//        hiltAndroidRule.inject()
//        userDao = appDatabase.userDao()
//    }
//
//    @Test
//    fun insertUser_returnsSingleUser() = runTest {
//        val user = User(0,"Jay", 30, "01/01/1990", "123 Street")
//        userDao.insertUser(user)
//        val result = userDao.getAllUsers()
//        Assert.assertEquals(1, result.size)
//    }
//
//
//    @After
//    fun closeDatabase() {
//        appDatabase.close()
//    }
//}