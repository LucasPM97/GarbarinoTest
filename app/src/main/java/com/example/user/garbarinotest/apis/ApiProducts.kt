package com.example.user.garbarinotest.apis

import com.example.user.garbarinotest.models.ResponseList
import retrofit2.Call
import retrofit2.http.GET

interface ApiProducts {

    @GET("products")
    fun getList(): Call<ResponseList>
}