package com.example.user.garbarinotest.apis

import com.example.user.garbarinotest.models.products.ResponseList
import com.example.user.garbarinotest.models.products.ResponsePost
import com.example.user.garbarinotest.models.reviews.ResponseReviews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProducts {

    @GET("products")
    fun getList(): Call<ResponseList>

    @GET("products/{productId}")
    fun getPost(@Path("productId") id: String): Call<ResponsePost>

    @GET("products/{productId}/reviews")
    fun getPostReviews(@Path("productId") id: String): Call<ResponseReviews>
}