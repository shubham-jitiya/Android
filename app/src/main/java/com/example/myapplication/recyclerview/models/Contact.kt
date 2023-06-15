package com.example.myapplication.recyclerview.models

import com.example.myapplication.R

data class Contact(
    val name: String,
    val email: String,
    val bio: String,
    val image: Int = R.drawable.ic_placeholder_person_filled,
    var isSelected: Boolean = false
)