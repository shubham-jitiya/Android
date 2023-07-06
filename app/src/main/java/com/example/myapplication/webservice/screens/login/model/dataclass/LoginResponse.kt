package com.example.myapplication.webservice.screens.login.model.dataclass

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") val token: String,
)