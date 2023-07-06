package com.example.myapplication.webservice.screens.userslist.model.dataclass

data class CreateUserResponse(
    val createdAt: String,
    val id: String,
    val job: String,
    val name: String
)