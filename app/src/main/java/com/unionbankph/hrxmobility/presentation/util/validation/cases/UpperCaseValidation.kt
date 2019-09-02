package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.regex.Pattern

class UpperCaseValidation : Validation() {

    override fun isValid(o: Any): Boolean {

        return if (o is String) {
            UPPER_CASE_VALIDATION.matcher(o).find()
        } else false

    }

    companion object {

        val UPPER_CASE_VALIDATION = Pattern.compile("[A-Z ]")
    }
}
