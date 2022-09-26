package com.example.composelogin.ui.loginScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composelogin.LoginViewModel
import com.example.composelogin.ui.loginScreen.content.Body
import com.example.composelogin.ui.loginScreen.footer.Footer
import com.example.composelogin.ui.loginScreen.header.Header

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(13.dp)
    ) {
        Header(modifier = Modifier.align(Alignment.TopEnd))
        Body(
            modifier = Modifier.align(Alignment.Center),
            loginViewModel = loginViewModel
        )
        Footer(modifier = Modifier.align(Alignment.BottomCenter))
    }
}