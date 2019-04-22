package com.example.user.garbarinotest.models

import com.google.gson.annotations.SerializedName

data class PostItem(

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("discount")
	val discount: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("list_price")
	val listPrice: Int? = null
){
	val hasDiscount = fun ():Boolean{
		return (discount?:0 > 0 && listPrice?:0 > price?:0)
	}
}