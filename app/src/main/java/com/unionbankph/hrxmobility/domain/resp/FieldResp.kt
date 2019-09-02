package com.unionbankph.hrxmobility.domain.resp

import com.google.gson.annotations.SerializedName

data class FieldResp(

	@field:SerializedName("type_id")
	val typeId: Int? = null,

	@field:SerializedName("width")
	val width: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("options")
	val options: List<String>? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("validations")
	val validations: List<ValidationsItem?>? = null
)