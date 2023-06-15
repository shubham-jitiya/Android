package com.example.myapplication.recyclerview.models

import com.example.myapplication.R

data class Mail(
    val senderName: String,
    val subject: String,
    val email: String,
    val timeStamp: String,
    val senderImage: Int = R.drawable.placeholder_gmail,
    val isImportant: Boolean = false,
    val attachment: Boolean = false,
    var isSelected: Boolean = false
) {
}