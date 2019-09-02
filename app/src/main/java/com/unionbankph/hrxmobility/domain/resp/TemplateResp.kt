package com.unionbankph.hrxmobility.domain.resp

import com.google.gson.annotations.SerializedName

data class TemplateResp(

	@field:SerializedName("date_created")
	val dateCreated: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("client_id")
	val clientId: Int? = null
)