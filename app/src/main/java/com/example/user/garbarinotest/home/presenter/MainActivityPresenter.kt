package com.example.user.garbarinotest.home.presenter

import com.example.user.garbarinotest.home.interactor.MainActivityInteractor

data class MainActivityPresenter (val view:MainActivityPresenter) {

    private val interactor:MainActivityInteractor = MainActivityInteractor(this)

    fun getPosts(){


    }

    fun returnPosts(){

    }

}