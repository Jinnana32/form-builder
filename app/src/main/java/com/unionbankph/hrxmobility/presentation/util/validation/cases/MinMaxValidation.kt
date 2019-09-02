package com.unionbankph.hrxmobility.presentation.util.validation.cases

import com.unionbankph.hrxmobility.presentation.util.validation.Validation

class MinMaxValidation(val min: Int, val max: Int) : Validation() {

    override fun isValid(o: Any): Boolean {
        val s = o.toString()

        return s.length >= min && s.length <= max
    }

    companion object {

        val OR_NUMBER = 20

        val SMALL = 70
        val MEDIUM = 255
    }
}
