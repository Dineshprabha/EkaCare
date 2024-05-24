package com.dineshprabha.ekacare.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.dineshprabha.ekacare.data.model.User
import com.dineshprabha.ekacare.presentation.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserForm(viewModel: UserViewModel) {

    var name by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var dob by remember {
        mutableStateOf("")
    }

    var address by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text(text = "Age") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = dob,
            onValueChange = { dob = it },
            label = { Text(text = "DOB") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(text = "Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val user = User(
                name = name,
                age = age.toInt(),
                dob = dob,
                address = address
            )

            viewModel.insertUser(user)
        }) {
            Text(text = "Submit")
        }
    }


}