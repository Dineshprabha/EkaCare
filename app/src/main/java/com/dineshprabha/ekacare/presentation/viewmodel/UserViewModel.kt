package com.dineshprabha.ekacare.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dineshprabha.ekacare.data.model.User
import com.dineshprabha.ekacare.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}