package com.example.myapplication.screens.practice.model.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class Post (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)