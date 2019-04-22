package com.example.user.garbarinotest.models.products

import com.google.gson.annotations.SerializedName

data class ResponsePost(

    @field:SerializedName("summary")
	val summary: String? = null,

    @field:SerializedName("price_without_vat")
	val priceWithoutVat: Double? = null,

    @field:SerializedName("virtual")
	val virtual: Boolean? = null,

    @field:SerializedName("price_matching_discount")
	val priceMatchingDiscount: Int? = null,

    @field:SerializedName("main_image")
	val mainImage: MainImage? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("discount")
	val discount: Int? = null,

    @field:SerializedName("resources")
	val resources: Resources? = null,

    @field:SerializedName("list_price")
	val listPrice: Int? = null,

    @field:SerializedName("original_brand")
	val originalBrand: String? = null,

    @field:SerializedName("product_tags")
	val productTags: List<Any?>? = null,

    @field:SerializedName("xid")
	val xid: String? = null,

    @field:SerializedName("category_id")
	val categoryId: Int? = null,

    @field:SerializedName("preferred_installment")
	val preferredInstallment: PreferredInstallment? = null,

    @field:SerializedName("price")
	val price: Int? = null,

    @field:SerializedName("enabled_for_sale")
	val enabledForSale: Boolean? = null,

    @field:SerializedName("model")
	val model: String? = null,

    @field:SerializedName("categories")
	val categories: List<Int?>? = null,

    @field:SerializedName("vat_percentage")
	val vatPercentage: Int? = null,

    @field:SerializedName("category")
	val category: String? = null,

    @field:SerializedName("brand")
	val brand: String? = null
)