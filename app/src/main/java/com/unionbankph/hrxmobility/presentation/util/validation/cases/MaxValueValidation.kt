package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class MaxValueValidation(val max: Float) : Validation() {

    override fun isValid(o: Any): Boolean {
        if (o is Double) {
            return o <= max
        }

        return if (o is Int) {

            o <= max
        } else false

    }
}
