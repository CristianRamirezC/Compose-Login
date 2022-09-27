package com.example.composelogin

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isPasswordIconVisible = MutableLiveData<Boolean>()
    val isPasswordIconVisible: LiveData<Boolean> = _isPasswordIconVisible

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
}