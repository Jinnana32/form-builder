package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class AtleastValidation(val mMin: Int) : Validation() {

    override fun isValid(o: Any): Boolean {
        return if (o is String) {

            o.length == mMin
        } else false
    }
}
