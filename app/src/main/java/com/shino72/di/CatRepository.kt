package com.shino72.di

import javax.inject.Inject

class CatRepository @Inject constructor(private val apiService: ApiService){
    suspend fun getCat(limit : String) = apiService.onGetCat(limit)
}