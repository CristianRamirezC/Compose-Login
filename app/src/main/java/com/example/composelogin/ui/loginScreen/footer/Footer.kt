package com.example.composelogin.ui.loginScreen.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFECECEC))
                .height(0.4.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        SignUp()
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun SignUp() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don't have an account?",
            modifier = Modifier.padding(horizontal = 5.dp),
            color = Color(0xFF9D9D9D),
            fontSize = 13.sp
        )
        Text(
            text = "Sign Up.",
            fontWeight = FontWeight.Medium,
            color = Color(0xFF0095F6),
            fontSize = 13.sp
        )
    }
}
