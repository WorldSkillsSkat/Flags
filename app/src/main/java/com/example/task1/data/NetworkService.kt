package com.example.task1.data

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService {

    private val api = Retrofit.Builder()
    .baseUrl("http://fspobot.tw1.ru:8080")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(JSONPlaceHolderApi::class.java)

    suspend fun addUser(user: User): Result<String> = coroutineScope {
        return@coroutineScope async {
            api.addUser(user)
        }.await()

    }

    suspend fun signIn(user: User): Result<String> = coroutineScope {
        return@coroutineScope async {
            api.signIn(user)
        }.await()

    }
}