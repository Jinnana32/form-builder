package com.unionbankph.hrxmobility.domain.common.exception

import com.google.gson.annotations.SerializedName

data class Errors(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)