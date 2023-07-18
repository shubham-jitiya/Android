package com.example.myapplication.screens.userslist.model.api

import com.example.myapplication.screens.login.model.*
import com.example.myapplication.screens.userslist.model.dataclass.CreateUserRequest
import com.example.myapplication.screens.userslist.model.dataclass.CreateUserResponse
import com.example.myapplication.screens.userslist.model.dataclass.SingleUser
import com.example.myapplication.screens.userslist.model.dataclass.UsersList
import retrofit2.Response
import retrofit2.http.*

interface UsersListApiService {
    @GET("users")
    suspend fun getUsersList(
        @Header("authorization") token: String,
        @QueryMap options: Map<String, Int>
    ): Response<UsersList>

    @GET("users/{id}")
    suspend fun getUserInfo(@Path("id") userId: Int): Response<SingleUser>

    @POST("users")
    suspend fun createUser(@Body createUserRequest: CreateUserRequest): Response<CreateUserResponse>
}