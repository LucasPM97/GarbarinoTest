package com.example.user.garbarinotest.home.interactor

import com.example.user.garbarinotest.Helper.ApiHelper
import com.example.user.garbarinotest.apis.ApiProducts
import com.example.user.garbarinotest.home.presenter.MainActivityPresenter
import com.example.user.garbarinotest.models.products.PostItem
import com.example.user.garbarinotest.models.products.ResponseList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class MainActivityInteractor(val presenter:MainActivityPresenter) {

    fun getPosts(){

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiHelper.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(ApiProducts::class.java)

        val call = endpoint.getList()

        call.enqueue(object : Callback<ResponseList> {
            override fun onFailure(call: Call<ResponseList>, t: Throwable) {
                showError()
            }

            override fun onResponse(call: Call<ResponseList>, response: Response<ResponseList>) {

                returnPosts(response.body()?.items)
            }


        })
    }

    private fun showError() {
        presenter.showError()
    }

    fun returnPosts(items: List<PostItem?>?){

        presenter.returnPosts(items)

    }

}