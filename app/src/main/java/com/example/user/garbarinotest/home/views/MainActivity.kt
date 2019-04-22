package com.example.user.garbarinotest.home.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.adapters.AdapterPosts
import com.example.user.garbarinotest.apis.ApiProducts
import com.example.user.garbarinotest.models.PostItem
import com.example.user.garbarinotest.models.ResponseList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this,2)

    }



    override fun onResume() {
        super.onResume()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://garbarino-mock-api.s3-website-us-east-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(ApiProducts::class.java)

        val call = endpoint.getList()

        call.enqueue(object : Callback<ResponseList> {
            override fun onFailure(call: Call<ResponseList>, t: Throwable) {
                showError()
            }

            override fun onResponse(call: Call<ResponseList>, response: Response<ResponseList>) {

                fillList(response.body()?.items)
            }


        })
    }

    public fun fillList(items: List<PostItem?>?) {

        recyclerView.adapter = AdapterPosts(items)


    }

    public fun showError(){

        recyclerView.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
    }
}
