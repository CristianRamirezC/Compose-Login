package com.example.composelogin.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composelogin.ui.loginScreen.LoginScreen
import com.example.composelogin.ui.theme.ComposeLoginTheme

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    ComposeLoginTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}