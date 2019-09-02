package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class AlphabetValidation : Validation() {

    override fun isValid(o: Any): Boolean {
        return (o as? String)?.matches("^[A-z\\s]+$".toRegex()) ?: false

    }
}
