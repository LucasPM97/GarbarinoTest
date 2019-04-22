package com.example.user.garbarinotest.home.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.adapters.AdapterPosts
import com.example.user.garbarinotest.apis.ApiProducts
import com.example.user.garbarinotest.home.presenter.MainActivityPresenter
import com.example.user.garbarinotest.models.PostItem
import com.example.user.garbarinotest.models.ResponseList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var presenter:MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar

        actionbar?.let {
            it.title = "Home"
        }

        recyclerView.layoutManager = GridLayoutManager(this,2)


        presenter = MainActivityPresenter(this)

    }



    override fun onResume() {
        super.onResume()

        presenter?.getPosts()

    }

    fun fillList(items: List<PostItem?>?) {

        recyclerView.adapter = AdapterPosts(items)


    }

    fun showError(){

        recyclerView.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
    }
}
