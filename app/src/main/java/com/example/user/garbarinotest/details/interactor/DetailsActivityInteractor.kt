package com.example.user.garbarinotest.home.interactor

import com.example.user.garbarinotest.Helper.ApiHelper
import com.example.user.garbarinotest.apis.ApiProducts
import com.example.user.garbarinotest.home.presenter.DetailsActivityPresenter
import com.example.user.garbarinotest.home.presenter.MainActivityPresenter
import com.example.user.garbarinotest.models.PostItem
import com.example.user.garbarinotest.models.ResponseList
import com.example.user.garbarinotest.models.ResponsePost
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

    private fun showError() {
    }


}