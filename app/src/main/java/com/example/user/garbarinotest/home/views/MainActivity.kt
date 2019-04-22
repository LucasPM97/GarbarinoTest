package com.example.user.garbarinotest.home.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.user.garbarinotest.R
import com.example.user.garbarinotest.adapters.AdapterPosts
import com.example.user.garbarinotest.home.presenter.MainActivityPresenter
import com.example.user.garbarinotest.models.products.PostItem
import kotlinx.android.synthetic.main.activity_main.*

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

        presenter?.let { pres ->

            if (pres.needReloadData()){
                pres.getPosts()
            }

        }

    }

    fun fillList(items: List<PostItem?>?) {

        recyclerView.adapter = AdapterPosts(items)


    }

    fun showError(){

        recyclerView.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
    }
}
