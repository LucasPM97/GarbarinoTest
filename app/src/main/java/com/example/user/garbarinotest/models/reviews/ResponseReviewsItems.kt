package com.example.user.garbarinotest.models.reviews

import com.google.gson.annotations.SerializedName

data class ResponseReviewsItems(

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem?>? = null,

	@field:SerializedName("review_statistics")
	val reviewStatistics: ReviewStatistics? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("total_review_count")
	val totalReviewCount: Int? = null
)