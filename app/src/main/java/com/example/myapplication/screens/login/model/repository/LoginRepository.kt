package com.example.myapplication.screens.login.model.repository

import android.util.Log
import com.example.myapplication.screens.login.model.api.LoginApiService
import com.example.myapplication.screens.login.model.dataclass.LoginRequest
import com.example.myapplication.screens.login.model.dataclass.LoginResponse

class LoginRepository(private val apiHandler: LoginApiService) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse? {
        val response = apiHandler.getToken(loginRequest)
        return if (response.body() != null && response.code() == 200) {
            response.body()
        } else {
            Log.d("TAG", "Login: <-- Something went wrong - ${response.code()}")
            null
        }
    }
}