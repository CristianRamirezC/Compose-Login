package com.example.composelogin.data.login.network

import com.example.composelogin.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin(
                user = user,
                password = password
            )
            response.body()?.success ?: false
        }
    }
}