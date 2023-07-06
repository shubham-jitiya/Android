package com.example.myapplication.webservice.screens.userslist.model.api

import com.example.myapplication.webservice.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UsersListRetrofitClient {
    val instance: Retrofit by lazy {
        createNewInstance()
    }

    private fun createNewInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_REQRES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}