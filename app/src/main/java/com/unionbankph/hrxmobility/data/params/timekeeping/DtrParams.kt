package com.unionbankph.hrxmobility.data.params.timekeeping

import com.google.gson.annotations.SerializedName

data class DtrParams(
	@field:SerializedName("user_id")
	val userId: String,
	@field:SerializedName("month")
	val month: String,
	@field:SerializedName("year")
	val year: String,
	@field:SerializedName("count")
	val count: String? = null
)