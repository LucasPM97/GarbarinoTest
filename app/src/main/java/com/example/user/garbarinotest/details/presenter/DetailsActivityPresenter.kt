package com.example.user.garbarinotest.home.presenter

import com.example.user.garbarinotest.details.views.DetailsActivity
import com.example.user.garbarinotest.home.interactor.DetailsActivityInteractor
import com.example.user.garbarinotest.home.interactor.MainActivityInteractor
import com.example.user.garbarinotest.home.views.MainActivity
import com.example.user.garbarinotest.models.PostItem
import com.example.user.garbarinotest.models.ResponsePost

data class DetailsActivityPresenter (private val view:DetailsActivity) {

    private val interactor = DetailsActivityInteractor(this)

    fun getPostData(id:String){

        interactor.getPost(id)

    }

    fun returnPostData(post: ResponsePost?){

        view.fillPostData(post)

    }



}