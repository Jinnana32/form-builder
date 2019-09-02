package com.unionbankph.hrxmobility.domain.common.exception

import com.google.gson.annotations.SerializedName

data class ErrorsItem(
	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)