package com.example.myapplication.webservice.screens.userslist.util

sealed class NetworkStatus {
    object Connected : NetworkStatus()
    object Disconnected : NetworkStatus()
}