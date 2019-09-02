package com.unionbankph.hrxmobility.domain.resp.timekeeping

import com.unionbankph.hrxmobility.domain.model.WeeklyDtr

data class DtrCollectionItem(val currentTimeData: WeeklyDtr,
                             val updatedTimeIn: String? = null,
                             val updatedTimeOut: String? = null,
                             val remarks: String)