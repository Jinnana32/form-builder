package com.unionbankph.hrxmobility.domain.resp

import com.google.gson.annotations.SerializedName

data class ValidationsItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("label")
	val label: String? = null
)