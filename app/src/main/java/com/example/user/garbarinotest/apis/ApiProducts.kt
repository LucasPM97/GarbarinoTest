package com.example.user.garbarinotest.apis

import com.example.user.garbarinotest.models.ResponseList
import com.example.user.garbarinotest.models.ResponsePost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiProducts {

    @GET("products")
    fun getList(): Call<ResponseList>

    @GET("products/{productId}")
    fun getPost(@Path("productId") id: String): Call<ResponsePost>
}