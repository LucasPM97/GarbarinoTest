package com.example.user.garbarinotest.models.reviews

import com.google.gson.annotations.SerializedName

data class RatingDistributionItem(

	@field:SerializedName("rating_value")
	val ratingValue: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null
)