package com.shino72.di

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("id") val id : String,
    @SerializedName("url") val url : String,
)