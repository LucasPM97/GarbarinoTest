package com.example.user.garbarinotest.models

import com.google.gson.annotations.SerializedName

data class Resources(

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("videos")
	val videos: List<Any?>? = null
)