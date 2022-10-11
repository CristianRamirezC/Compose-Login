package com.example.composelogin.data.login

import com.example.composelogin.data.login.network.LoginService

class LoginRepository {

    private val api = LoginService()

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(
            user = user,
            password = password
        )
    }
}