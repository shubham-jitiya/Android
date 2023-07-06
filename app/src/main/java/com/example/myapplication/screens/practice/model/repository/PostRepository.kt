package com.example.myapplication.screens.practice.model.repository

import android.util.Log
import com.example.myapplication.screens.practice.model.api.UsersPostApiService
import com.example.myapplication.screens.practice.model.dataclass.Post
import com.example.myapplication.screens.userslist.model.dataclass.UsersList
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import java.io.IOException

class PostRepository(private val apiService: UsersPostApiService) {

    suspend fun getPostById(postId: Int): Post? {
        val result = apiService.getSinglePostById(postId)
        return if (result.body() != null && result.isSuccessful) {
            result.body()
        } else {
            null
        }
    }

    suspend fun getAllPosts(): ArrayList<Post>? {
        val result = apiService.getAllPost("AuthKey")
        return if (result.body() != null && result.isSuccessful) {
            Log.d("TAG", "getAllPosts: Header: ${result.headers()}")
            result.body()
        } else {
            null
        }
    }

    suspend fun pushPost(post: Post): Post? {
        val result = apiService.createPost(post)
        return if (result.body() != null && result.isSuccessful) {
            Log.d("TAG", "pushPost status code: ${result.code()}")
            Log.d("TAG", "pushPost header code: ${result.headers()}")
            result.body()
        } else {
            Log.d("TAG", "pushPost: ${result.code()}")
            null
        }
    }

    suspend fun pushEncryptedPost(post: Post): Post? {
        val result = apiService.createEncryptedPost(post.userId, post.id, post.title, post.body)
        return if (result.body() != null && result.isSuccessful) {
            result.body()
        } else {
            null
        }
    }

    suspend fun searchPost(userId: Int): ArrayList<Post>? {
        val result = apiService.getMultiplePostByUserId(userId)
        return if (result.body() != null && result.isSuccessful) {
            result.body()
        } else {
            null
        }
    }

    suspend fun sortPost(userId: Int, sort: String, order: String): ArrayList<Post>? {
        val result = apiService.sortPost(userId, sort, order)
        return if (result.body() != null && result.isSuccessful) {
            result.body()
        } else {
            null
        }
    }

    suspend fun sortPostByMap(userId: Int, options: Map<String, String>): ArrayList<Post>? {
        val result = apiService.sortPost(userId, options)
        return if (result.body() != null && result.isSuccessful) {
            result.body()
        } else {
            null
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun getWithOKHttp() {
        val url = "https://reqres.in/api/users?page=2"
        val httpClient = OkHttpClient()
        val request = Request.Builder().url(url).build()
        httpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ${e.localizedMessage}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    try {
                        val responseData = response.body?.string()
                        responseData?.let {
                            val result = Json.decodeFromString<UsersList>(it)
                            Log.d("TAG", "onResponse success: ${result.data.first()}")
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResponse exception: ${e.localizedMessage}")
                    }
                }
            }
        })
    }
}