package com.unionbankph.hrxmobility.presentation.util.validation.cases

import android.text.TextUtils
import com.unionbankph.hrxmobility.presentation.util.validation.Validation

import java.util.Calendar

class FutureYearValidation : Validation() {

    override fun isValid(o: Any): Boolean {
        if (o is String) {

            return TextUtils.isDigitsOnly(o) && Integer.parseInt(o) <= Calendar.getInstance().get(Calendar.YEAR)
        } else if (o is Int) {

            return o <= Calendar.getInstance().get(Calendar.YEAR)
        }

        return false
    }
}
