package com.dineshprabha.ekacare.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.dineshprabha.ekacare.presentation.viewmodel.UserViewModel
import com.dineshprabha.ekacare.ui.theme.focusedTextFiledText
import com.dineshprabha.ekacare.ui.theme.textFieldContainer
import com.dineshprabha.ekacare.ui.theme.unfocusedTextFiledText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    trailing: String,
    onTrailingClick: () -> Unit,
    trailingIcon: ImageVector? = null // Add this parameter for the icon
) {

    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
        },
        colors = TextFieldDefaults.textFieldColors(
            disabledPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFiledText,
            placeholderColor = MaterialTheme.colorScheme.focusedTextFiledText,
            containerColor = MaterialTheme.colorScheme.textFieldContainer
        ),
        trailingIcon = {
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null, // Add appropriate content description here
                    tint = uiColor,
                    modifier = Modifier.clickable { onTrailingClick() }
                )
            }
        }
    )

}