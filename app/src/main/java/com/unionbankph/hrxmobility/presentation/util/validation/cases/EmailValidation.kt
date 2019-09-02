package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.regex.Pattern

class EmailValidation : Validation() {

    override fun isValid(o: Any): Boolean {

        return if (o is String) {
            EMAIL_PATTERN.matcher(o).find()
        } else false

    }

    companion object {

        private val EMAIL_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    }
}
