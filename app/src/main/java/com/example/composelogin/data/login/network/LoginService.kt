package com.example.composelogin.data.login.network

import com.example.composelogin.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(
    private val api: LoginApiClient
) {
    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = api.doLogin()
            response.body()?.success ?: false
        }
    }
}