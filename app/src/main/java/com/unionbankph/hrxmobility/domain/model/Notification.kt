package com.unionbankph.hrxmobility.domain.model

data class Notification(
    val tag: String,
    val title: String,
    val message: String,
    val time: String
)