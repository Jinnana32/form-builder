package com.unionbankph.hrxmobility.domain.common.exception


import com.google.gson.annotations.SerializedName

data class ErrorResp(
	@field:SerializedName("errors")
	val errors: List<ErrorsItem?>? = null
)