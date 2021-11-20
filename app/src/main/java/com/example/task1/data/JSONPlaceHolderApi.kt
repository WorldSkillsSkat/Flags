package com.example.task1.data

import retrofit2.http.Body
import retrofit2.http.POST

interface JSONPlaceHolderApi {
    @POST("/auth/register")
    suspend fun addUser(@Body user: User): Result<String>

    @POST("/auth/login")
    suspend fun signIn(@Body user: User): Result<String>

}