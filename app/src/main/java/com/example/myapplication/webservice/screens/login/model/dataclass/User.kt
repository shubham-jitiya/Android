package com.example.myapplication.webservice.screens.login.model.dataclass

@kotlinx.serialization.Serializable
data class User(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)