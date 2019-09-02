package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.Calendar

class DateValidation(private val mFromDate: Calendar) : Validation() {

    override fun isValid(o: Any): Boolean {
        val toDate = o as Calendar
        return mFromDate.time.before(toDate.time)
    }
}
