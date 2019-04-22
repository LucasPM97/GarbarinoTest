package com.example.user.garbarinotest.home.interactor

import com.example.user.garbarinotest.Helper.ApiHelper
import com.example.user.garbarinotest.apis.ApiProducts
import com.example.user.garbarinotest.home.presenter.DetailsActivityPresenter
import com.example.user.garbarinotest.models.products.ResponsePost
import com.example.user.garbarinotest.models.reviews.ResponseReviews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class DetailsActivityInteractor(val presenter:DetailsActivityPresenter) {

    fun getPost(id:String){

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiHelper.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(ApiProducts::class.java)

        val call = endpoint.getPost(id)

        call.enqueue(object : Callback<ResponsePost> {

            override fun onFailure(call: Call<ResponsePost>, t: Throwable) {
                showError()
            }

            override fun onResponse(call: Call<ResponsePost>, response: Response<ResponsePost>) {

                returnPostData(response.body())
            }

        })
    }

    private fun returnPostData(post: ResponsePost?){

        presenter.returnPostData(post)

    }

    fun getPostReviews(id:String){

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiHelper.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(ApiProducts::class.java)

        val call = endpoint.getPostReviews(id)

        call.enqueue(object : Callback<ResponseReviews> {

            override fun onFailure(call: Call<ResponseReviews>, t: Throwable) {
                showError()
            }

            override fun onResponse(call: Call<ResponseReviews>, response: Response<ResponseReviews>) {

                returnPostReviews(response.body())
            }

        })
    }

    private fun returnPostReviews(reviews: ResponseReviews?){

        reviews?.items?.first().let {
            presenter.returnPostReviews(it)

        }


    }

    private fun showError() {
    }


}