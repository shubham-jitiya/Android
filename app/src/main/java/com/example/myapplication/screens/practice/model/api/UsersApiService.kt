package com.example.myapplication.screens.practice.model.api

import com.example.myapplication.screens.userslist.model.dataclass.UsersList

interface UsersApiService {
    suspend fun getUsers(): UsersList?
}