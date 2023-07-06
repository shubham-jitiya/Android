package com.example.myapplication.webservice.screens.userslist.model.dataclass

import com.example.myapplication.webservice.screens.login.model.dataclass.Support
import com.example.myapplication.webservice.screens.login.model.dataclass.User


data class SingleUser(
    val `data`: User,
    val support: Support
)