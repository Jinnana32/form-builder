package com.unionbankph.hrxmobility.domain.model

class WeeklyDtr (
    val dtr_id: String,
    val dayOfWeek: String,
    val dayOfWeekName: String,
    val timeIn: String,
    val timeOut: String,
    val status: String,
    val breaks: List<EmployeeBreaks>?
)