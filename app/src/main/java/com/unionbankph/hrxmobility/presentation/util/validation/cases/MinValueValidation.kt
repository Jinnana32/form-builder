package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class MinValueValidation(val min: Float) : Validation() {

    override fun isValid(o: Any): Boolean {
        if (o is Double) {
            return o >= min
        }

        return if (o is Int) {

            o >= min
        } else false

    }
}
