package com.example.task1.data

import com.example.task1.flags.Flag
import retrofit2.Call
import retrofit2.http.GET

interface JSONFlagsHolderApi {
    @GET("/v3.1/all")
    suspend fun getCountries() : Array<Flag>
}