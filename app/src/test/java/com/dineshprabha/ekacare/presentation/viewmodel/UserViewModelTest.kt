package com.dineshprabha.ekacare.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import com.dineshprabha.ekacare.data.local.AppDatabase
import com.dineshprabha.ekacare.data.local.UserDao
import com.dineshprabha.ekacare.data.model.User
import com.dineshprabha.ekacare.domain.repository.UserRepository
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class UserViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var appDatabase: AppDatabase
    lateinit var userDao: UserDao
    lateinit var viewModel: UserViewModel

    @Before
    fun setUp(){

    }

    @Test
    fun insertUser_expectedSingleUser() = runBlocking{

    }


    @After
    fun tearDown(){

    }



}