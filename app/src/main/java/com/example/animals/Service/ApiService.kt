package com.example.animals.Service

import com.example.animals.Model.Animal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int = 1
    ): Response<List<Animal>>

    @GET("images/search")
    suspend fun getDogs(
        @Query("limit") limit: Int = 1
    ): Response<List<Animal>>
}