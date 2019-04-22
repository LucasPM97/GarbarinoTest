package com.example.user.garbarinotest.models.products

import com.google.gson.annotations.SerializedName

data class ImagesItem(

	@field:SerializedName("max_width")
	val maxWidth: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)