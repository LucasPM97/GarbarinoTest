package com.example.user.garbarinotest.home.presenter

import com.example.user.garbarinotest.details.views.DetailsActivity
import com.example.user.garbarinotest.home.interactor.DetailsActivityInteractor
import com.example.user.garbarinotest.models.products.ResponsePost
import com.example.user.garbarinotest.models.reviews.ResponseReviewsItems
import com.example.user.garbarinotest.utils.splitByDot


data class DetailsActivityPresenter (private val view:DetailsActivity) {

    private val interactor = DetailsActivityInteractor(this)

    fun getPostData(id:String){

        interactor.getPost(id)

    }

    fun returnPostData(post: ResponsePost?){

        view.fillPostData(post)

    }

    fun returnPostReviews(reviews: ResponseReviewsItems?) {

        reviews?.let {

            view.addReviewsStars(it.reviewStatistics)
            view.addReviews(it.reviews?.take(3))
            view.Reviews = it
        }
    }


    fun divideSummary(summary: String?) {
        val list = summary?.splitByDot()

        list?.let {

            for (item in it) {
                view.addDescriptionDividerView(item)
            }
        }


    }

    fun getPostReviews(id: String?) {

        id?.let {
            interactor.getPostReviews(it)
        }

    }
}