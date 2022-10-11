package com.example.composelogin.ui.loginScreen.viewModel

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelogin.domain.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isPasswordIconVisible = MutableLiveData<Boolean>()
    val isPasswordIconVisible: LiveData<Boolean> = _isPasswordIconVisible

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password

        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.length > 5

    fun onPasswordVisibilityIconPressed(isPasswordIconVisible: Boolean) {
        _isPasswordIconVisible.value = isPasswordIconVisible.not()
    }

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val loginResult = loginUseCase(user = email.value!!, password = password.value!!)
            if (loginResult) {
                Log.i("instagramLogin", "Login successful!")
            }
            _isLoading.value = false
        }
    }
}