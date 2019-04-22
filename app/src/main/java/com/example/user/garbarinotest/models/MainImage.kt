package com.example.user.garbarinotest.models

import com.google.gson.annotations.SerializedName

data class MainImage(

	@field:SerializedName("max_width")
	val maxWidth: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)