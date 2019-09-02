package com.unionbankph.hrxmobility.domain.common.exception

import com.google.gson.annotations.SerializedName

data class ErrResponse(

	@field:SerializedName("error")
	val error: ErrorsItem? = null
)