package com.example.composelogin.ui.loginScreen.content

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelogin.ui.loginScreen.viewModel.LoginViewModel
import com.example.composelogin.R

@Composable
fun Body(modifier: Modifier = Modifier, loginViewModel: LoginViewModel) {
    val email by loginViewModel
        .email
        .observeAsState(initial = "")
    val password by loginViewModel
        .password
        .observeAsState(initial = "")
    val isLoginEnable by loginViewModel
        .isLoginEnable
        .observeAsState(initial = false)
    val isPasswordIconVisible by loginViewModel
        .isPasswordIconVisible
        .observeAsState(initial = false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(40.dp))
        EmailField(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(12.dp))
        PasswordField(
            password = password,
            isPasswordIconVisible = isPasswordIconVisible,
            onPasswordVisibilityIconPressed = {
                loginViewModel.onPasswordVisibilityIconPressed(it)
            }
        ) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(20.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(25.dp))
        LoginButton(
            isLoginEnable = isLoginEnable,
            loginViewModel = loginViewModel
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Facebook logo",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "Continue as Dave Johnson",
            fontSize = 15.sp,
            color = Color(0xFF0095F6),
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable {
                    Toast
                        .makeText(context, "Login with facebook", Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Divider(
            Modifier
                .background(Color(0xFFECECEC))
                .height(0.4.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 25.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFA4A4A4)
        )
        Divider(
            Modifier
                .background(Color(0xFFECECEC))
                .height(0.4.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(
    isLoginEnable: Boolean,
    loginViewModel: LoginViewModel
) {
    Button(
        onClick = {
            loginViewModel.onLoginSelected()
        },
        enabled = isLoginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF0095F6),
            disabledBackgroundColor = Color(0xFF77C8F8),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Forgot Password?",
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF0095F6),
        modifier = modifier
            .clickable {
                Toast
                    .makeText(context, "Forgot Password", Toast.LENGTH_SHORT)
                    .show()
            },
    )
}

@Composable
fun PasswordField(
    password: String,
    isPasswordIconVisible: Boolean,
    onPasswordVisibilityIconPressed: (Boolean) -> Unit,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Password", color = Color(0xFFA7A7A7))
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val passwordVisibilityIcon = if (isPasswordIconVisible) {
                Icons.Outlined.VisibilityOff
            } else {
                Icons.Outlined.Visibility
            }
            IconButton(onClick = {
                onPasswordVisibilityIconPressed(isPasswordIconVisible)
            }) {
                Icon(
                    imageVector = passwordVisibilityIcon,
                    contentDescription = "Show password"
                )
            }
        },
        visualTransformation = if (isPasswordIconVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun EmailField(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Email", color = Color(0xFFA7A7A7))
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ImageLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Application logo",
        modifier = modifier
    )
}
