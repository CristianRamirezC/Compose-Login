package com.example.composelogin.ui.loginScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.composelogin.ui.loginScreen.content.Content
import com.example.composelogin.ui.loginScreen.footer.Footer
import com.example.composelogin.ui.loginScreen.header.Header

@Composable
fun LoginScreen() {
    Header()
    Content()
    Footer()
}