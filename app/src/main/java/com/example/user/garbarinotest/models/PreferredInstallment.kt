package com.example.user.garbarinotest.models

import com.google.gson.annotations.SerializedName

data class PreferredInstallment(

	@field:SerializedName("surcharge")
	val surcharge: Double? = null,

	@field:SerializedName("tfc")
	val tfc: Double? = null,

	@field:SerializedName("eapr")
	val eapr: Double? = null,

	@field:SerializedName("installment_price")
	val installmentPrice: Double? = null,

	@field:SerializedName("installments")
	val installments: Int? = null,

	@field:SerializedName("interest")
	val interest: Double? = null,

	@field:SerializedName("final_price")
	val finalPrice: Double? = null,

	@field:SerializedName("gateway_installments")
	val gatewayInstallments: Int? = null,

	@field:SerializedName("visa_financing")
	val visaFinancing: Boolean? = null,

	@field:SerializedName("base_price")
	val basePrice: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("repayment")
	val repayment: Int? = null
)