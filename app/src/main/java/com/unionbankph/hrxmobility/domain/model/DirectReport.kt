package com.unionbankph.hrxmobility.domain.model

data class DirectReport(
    val id: Int? = null,
    val employeeId: Int? = null,
    val firstname: String? = null,
    val middleName: String?,
    val lastName: String? = null,
    val position: String? = null,
    val unitId: Int? = null,
    val unitName: String? = null,
    val rank: String? = null
)