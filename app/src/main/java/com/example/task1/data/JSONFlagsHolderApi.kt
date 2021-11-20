package com.example.task1.data

import com.example.task1.country.Country
import retrofit2.http.GET

interface JSONFlagsHolderApi {
    @GET("/v3.1/all")
    suspend fun getCountries() : Array<Country>
}