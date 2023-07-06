package com.example.myapplication.webservice.screens.userslist.model.repository

import android.util.Log
import com.example.myapplication.webservice.screens.userslist.model.api.UsersListApiService
import com.example.myapplication.webservice.screens.userslist.model.dataclass.CreateUserRequest
import com.example.myapplication.webservice.screens.userslist.model.dataclass.CreateUserResponse
import com.example.myapplication.webservice.screens.userslist.model.dataclass.SingleUser
import com.example.myapplication.webservice.screens.userslist.model.dataclass.UsersList

class UserListRepository(private val apiHandler: UsersListApiService) {
    suspend fun fetchUsersList(token: String, options: Map<String, Int>): UsersList? {
        val result = apiHandler.getUsersList(token, options)
        if (result.body() != null) {
            return result.body()
        }
        return null
    }

    suspend fun fetchUserInfo(userId: Int): SingleUser? {
        val response = apiHandler.getUserInfo(userId)
        return if (response.body() != null) {
            response.body()
        } else {
            Log.d("TAG", "fetchUserInfo: ${response.errorBody()}")
            null
        }
    }

    suspend fun createUser(user: CreateUserRequest): CreateUserResponse? {
        val response = apiHandler.createUser(user)
        return if (response.body() != null) {
            response.body()
        } else {
            Log.d("TAG", "createUser: ${response.errorBody()}")
            null
        }
    }
}