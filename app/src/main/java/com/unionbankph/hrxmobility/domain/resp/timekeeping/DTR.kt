package com.unionbankph.hrxmobility.domain.resp.timekeeping

import com.google.gson.annotations.SerializedName

data class DTR(

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("time_in")
	val timeIn: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("time_out")
	val timeOut: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)