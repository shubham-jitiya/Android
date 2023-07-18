package com.example.myapplication.screens.login.model.api

import com.example.myapplication.screens.login.model.*
import com.example.myapplication.screens.login.model.dataclass.LoginRequest
import com.example.myapplication.screens.login.model.dataclass.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface LoginApiService {
    @POST("login")
    suspend fun getToken(@Body loginRequest: LoginRequest): Response<LoginResponse>
}