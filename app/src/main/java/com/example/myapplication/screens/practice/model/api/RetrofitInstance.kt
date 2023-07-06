package com.example.myapplication.screens.practice.model.api

import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.PostInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val interceptor = OkHttpClient.Builder().apply {
        addInterceptor(PostInterceptor())
    }.build()
    val instance: Retrofit by lazy {
        createNewInstance()
    }

    private fun createNewInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(interceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}