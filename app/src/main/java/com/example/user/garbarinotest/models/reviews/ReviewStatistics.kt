package com.example.user.garbarinotest.models.reviews

import com.google.gson.annotations.SerializedName

data class ReviewStatistics(

	@field:SerializedName("average_overall_rating")
	val averageOverallRating: Double? = null,

	@field:SerializedName("rating_distribution")
	val ratingDistribution: List<RatingDistributionItem?>? = null
)