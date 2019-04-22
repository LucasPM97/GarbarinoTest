package com.example.user.garbarinotest.models.products

import com.google.gson.annotations.SerializedName

data class ResponseList(

	@field:SerializedName("items")
	val items: List<PostItem?>? = null
)