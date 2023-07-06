package com.example.myapplication.webservice.screens.userslist.model.dataclass

import com.example.myapplication.webservice.screens.login.model.dataclass.Support
import com.example.myapplication.webservice.screens.login.model.dataclass.User


@kotlinx.serialization.Serializable
data class UsersList(
    // update page, perpage, support fields to req parameter
    val `data`: List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)