package com.example.composelogin.domain.login

import com.example.composelogin.data.login.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(
            user = user,
            password = password
        )
    }
}