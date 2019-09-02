package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class RequiredValidation : Validation() {

    override fun isValid(o: Any): Boolean {
        if (o is String) {
            return !o.isEmpty()
        }

        if (o is Double) {
            return o > 0
        }

        if (o is Int) {
            return o > 0
        }

        return if (o != null && o is List<*>) {
            o.size > 0
        } else o != null

    }
}
