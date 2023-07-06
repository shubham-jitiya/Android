package com.example.myapplication.webservice.screens.practice.model.api

import com.example.myapplication.webservice.screens.userslist.model.dataclass.UsersList


interface UsersApiService {
    suspend fun getUsers(): UsersList?
}