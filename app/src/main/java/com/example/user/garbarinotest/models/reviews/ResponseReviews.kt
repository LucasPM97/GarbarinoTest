package com.example.user.garbarinotest.models.reviews

import com.google.gson.annotations.SerializedName

data class ResponseReviews(

	@field:SerializedName("items")
	val items: List<ResponseReviewsItems?>? = null
)