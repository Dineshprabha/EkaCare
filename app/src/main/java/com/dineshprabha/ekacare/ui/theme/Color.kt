package com.dineshprabha.ekacare.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val MutedBlack = Color(0xFF1A1C1E)

val Black = Color(0xFF5451F2)
val LightBlueWhite = Color(0xFFF2F1F9) //Social media background
val BlueGray = Color(0xFFA499F7)

val ColorScheme.focusedTextFiledText
    @Composable
    get() = if  (isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.unfocusedTextFiledText
    @Composable
    get() = if  (isSystemInDarkTheme()) Color(0xFF5451F2) else Color(0xFFF1F5F9)

val ColorScheme.textFieldContainer
    @Composable
    get() = if  (isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite