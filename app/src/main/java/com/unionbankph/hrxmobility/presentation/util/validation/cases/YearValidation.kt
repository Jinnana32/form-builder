package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class YearValidation : Validation() {

    override fun isValid(o: Any): Boolean {
        if (o is String) {

            return o.matches("^\\d{1,10}$".toRegex()) && o.length == 4
        }

        if (o is Int) {
            val s = o.toString()

            return s.matches("^\\d{1,10}$".toRegex()) && s.length == 4
        }

        return false
    }
}
