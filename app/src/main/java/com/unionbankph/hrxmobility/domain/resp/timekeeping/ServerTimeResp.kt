package com.unionbankph.hrxmobility.domain.resp.timekeeping

import com.google.gson.annotations.SerializedName

data class ServerTimeResp(

	@field:SerializedName("previousPage")
	val previousPage: Any? = null,

	@field:SerializedName("data")
	val data: List<String?>? = null,

	@field:SerializedName("nextPage")
	val nextPage: Any? = null,

	@field:SerializedName("totalPages")
	val totalPages: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null,

	@field:SerializedName("totalRecord")
	val totalRecord: Int? = null
)