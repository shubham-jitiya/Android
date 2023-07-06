package com.example.myapplication.webservice.screens.practice.model.api

import com.example.myapplication.webservice.screens.practice.model.dataclass.Post
import retrofit2.Response
import retrofit2.http.*

interface UsersPostApiService {
    @GET("/posts")
    suspend fun getMultiplePostByUserId(@Query("userId") userId: Int): Response<ArrayList<Post>>

    @GET("/posts/{id}")
    suspend fun getSinglePostById(@Path("id") postId: Int): Response<Post>

    @GET("/posts")
    suspend fun getAllPost(@Header("Auth") auth: String): Response<ArrayList<Post>>

    @Headers("Auth: 11")
    @POST("/posts")
    suspend fun createPost(@Body post: Post): Response<Post>

    @FormUrlEncoded
    @POST("/posts")
    suspend fun createEncryptedPost(
        @Field("userID") userID: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Post>

    @GET("/posts")
    suspend fun sortPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String,
    ): Response<ArrayList<Post>>

    @GET("/posts")
    suspend fun sortPost(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>,
    ): Response<ArrayList<Post>>
}