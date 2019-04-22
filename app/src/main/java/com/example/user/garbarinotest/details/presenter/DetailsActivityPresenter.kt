package com.example.user.garbarinotest.home.presenter

import com.example.user.garbarinotest.details.views.DetailsActivity
import com.example.user.garbarinotest.home.interactor.DetailsActivityInteractor
import com.example.user.garbarinotest.home.interactor.MainActivityInteractor
import com.example.user.garbarinotest.home.views.MainActivity
import com.example.user.garbarinotest.models.PostItem
import com.example.user.garbarinotest.models.ResponsePost
import com.example.user.garbarinotest.utils.splitByDot
import android.accounts.Account



data class DetailsActivityPresenter (private val view:DetailsActivity) {

    private val interactor = DetailsActivityInteractor(this)

    fun getPostData(id:String){

        interactor.getPost(id)

    }

    fun returnPostData(post: ResponsePost?){

        view.fillPostData(post)

    }

    fun divideSummary(summary: String?) {
        val list = summary?.splitByDot()

        list?.let {

            for (item in it) {
                view.addDescriptionDividerView(item)
            }
        }


    }


}