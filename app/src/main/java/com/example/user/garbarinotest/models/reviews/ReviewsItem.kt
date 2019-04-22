package com.example.user.garbarinotest.models.reviews

import com.google.gson.annotations.SerializedName
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class ReviewsItem(

	@field:SerializedName("submission_time")
	val submissionTime: String? = null,

	@field:SerializedName("product_id")
	val productId: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("review_text")
	val reviewText: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("usernickname")
	val usernickname: String? = null
)