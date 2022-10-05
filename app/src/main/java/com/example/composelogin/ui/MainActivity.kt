package com.example.composelogin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelogin.ui.AppTheme
import com.example.composelogin.ui.loginScreen.LoginScreen
import com.example.composelogin.ui.loginScreen.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LoginScreen(loginViewModel = LoginViewModel())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyLogin() {
}