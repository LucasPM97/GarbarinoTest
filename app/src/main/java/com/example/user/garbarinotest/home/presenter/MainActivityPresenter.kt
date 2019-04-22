package com.example.user.garbarinotest.home.presenter

import com.example.user.garbarinotest.home.interactor.MainActivityInteractor
import com.example.user.garbarinotest.home.views.MainActivity
import com.example.user.garbarinotest.models.products.PostItem
import kotlinx.android.synthetic.main.activity_main.*

data class MainActivityPresenter (private val view:MainActivity) {

    private val interactor = MainActivityInteractor(this)

    fun getPosts(){

        interactor.getPosts()

    }

    fun returnPosts(items: List<PostItem?>?){

        view.fillList(items)

    }

    fun showError() {
        view.showError()
    }

    fun needReloadData(): Boolean {
        var response = true

        view.recyclerView?.adapter?.let {adapter ->
            if (adapter.itemCount > 0){

                response = false
            }
        }
        return response
    }

}