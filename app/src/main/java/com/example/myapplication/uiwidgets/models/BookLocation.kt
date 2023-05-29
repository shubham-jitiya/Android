package com.example.myapplication.uiwidgets.models

data class BookLocation(
    private val accountType: String,
    private val schedule: String,
    private val dateAfter: String,
    private val timeAfter: String,
    private val dateBefore: String,
    private val timeBefore: String
)