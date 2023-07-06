package com.example.myapplication.webservice.utils

import okhttp3.Interceptor
import okhttp3.Response

class PostInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Platform", "Android")
            .addHeader("X-Auth-Token", "123456789")
            .build()
        return chain.proceed(request)
    }
}