package com.shino72.di

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun onGetCat (@Query("limit") limit : String ): Response<List<Cat>>
}