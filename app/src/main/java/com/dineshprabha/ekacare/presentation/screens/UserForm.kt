package com.dineshprabha.ekacare.presentation.screens

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dineshprabha.ekacare.R
import com.dineshprabha.ekacare.data.model.User
import com.dineshprabha.ekacare.presentation.viewmodel.UserViewModel
import com.dineshprabha.ekacare.ui.theme.Black
import com.dineshprabha.ekacare.ui.theme.BlueGray
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserForm(
    viewModel: UserViewModel
) {



    Surface {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopSection()

            Spacer(modifier = Modifier.height(6.dp))

            FormSection(viewModel)

        }
    }
}

@Composable
fun FormSection(viewModel: UserViewModel) {

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

    val context = LocalContext.current
    val calender = Calendar.getInstance()


    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayofMonth ->
            dob = "$dayofMonth/${month + 1}/$year"
        },
        calender.get(Calendar.YEAR),
        calender.get(Calendar.MONTH),
        calender.get(Calendar.DAY_OF_MONTH)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        UserTextField(
            label = "Name",
            value = name,
            onValueChange = { name = it },
            trailing = "",
            onTrailingClick = {}
        )
        Spacer(modifier = Modifier.height(5.dp))

        UserTextField(
            label = "Age",
            value = age,
            onValueChange = { age = it },
            trailing = "",
            onTrailingClick = {}
        )
        Spacer(modifier = Modifier.height(5.dp))

        UserTextField(
            label = "DOB",
            value = dob,
            onValueChange = {},
            trailing = "",
            onTrailingClick = { datePickerDialog.show() },
            modifier = Modifier.clickable { datePickerDialog.show() },
            trailingIcon = Icons.Default.DateRange
        )
        Spacer(modifier = Modifier.height(5.dp))

        UserTextField(
            label = "Address",
            value = address,
            onValueChange = { address = it },
            trailing = "",
            onTrailingClick = {}
        )
        Spacer(modifier = Modifier.height(15.dp))


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = {
                if (name.isBlank() || age.isBlank() || dob.isBlank() || address.isBlank()){
                    Toast.makeText(context, "All fields must be filled", Toast.LENGTH_SHORT).show()
                }
                else{
                    val user = User(
                        name = name,
                        age = age.toIntOrNull() ?: 0,
                        dob = dob,
                        address = address
                    )
                    viewModel.insertUser(user)
                    Toast.makeText(context, "Data saved successfully", Toast.LENGTH_SHORT).show()

                    // To clear the text fields
                    name = ""
                    age = ""
                    dob = ""
                    address = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(size = 40.dp)
        ) {
            Text(
                text = "Submit",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.35f),
            painter = painterResource(id = R.drawable.home_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier.size(63.dp),
                painter = painterResource(id = R.drawable.eka_logo),
                contentDescription = stringResource(
                    id = R.string.app_logo
                ),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.eka_care),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
            }
        }

    }
}