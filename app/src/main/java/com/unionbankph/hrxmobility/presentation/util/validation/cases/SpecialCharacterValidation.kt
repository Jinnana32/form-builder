package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.regex.Pattern

class SpecialCharacterValidation : Validation() {

    override fun isValid(o: Any): Boolean {

        return if (o is String) {
            SPECIAL_CHAR_VALIDATION.matcher(o).find()
        } else false

    }

    companion object {

        val SPECIAL_CHAR_VALIDATION = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE)
    }
}
