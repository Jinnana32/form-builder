package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.regex.Pattern

class NumberValidation : Validation() {

    override fun isValid(o: Any): Boolean {

        return if (o is String) {
            NUMBER_VALIDATION.matcher(o).find()
        } else false

    }

    companion object {

        val NUMBER_VALIDATION = Pattern.compile("[0-9 ]")
    }
}
