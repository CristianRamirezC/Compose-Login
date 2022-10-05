package com.example.composelogin.data.login.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success: Boolean
)
