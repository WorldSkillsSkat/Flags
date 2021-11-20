package com.example.task1.data

import com.example.task1.country.Country
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService {


    private val apiAuth = Retrofit.Builder()
        .baseUrl("http://fspobot.tw1.ru:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JSONAuthHolderApi::class.java)

    private val apiFlags = Retrofit.Builder()
        .baseUrl("https://restcountries.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JSONFlagsHolderApi::class.java)

    suspend fun getCountries(): Array<Country> = coroutineScope {
        return@coroutineScope async {
            apiFlags.getCountries()
        }.await()
    }

    suspend fun addUser(user: User): Result<String> = coroutineScope {
        return@coroutineScope async {
            apiAuth.addUser(user)
        }.await()
    }

    suspend fun signIn(user: User): Result<String> = coroutineScope {
        return@coroutineScope async {
            apiAuth.signIn(user)
        }.await()
    }
}