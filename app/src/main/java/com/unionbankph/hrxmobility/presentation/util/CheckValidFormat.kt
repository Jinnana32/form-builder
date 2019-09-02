package com.unionbankph.hrxmobility.presentation.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CheckValidFormat {

    companion object {
        fun isValidFormat(format: String, value: String): Boolean {
            var date: Date? = null
            try {
                val sdf = SimpleDateFormat(format)
                date = sdf.parse(value)
                if (value != sdf.format(date)) {
                    date = null
                }
            } catch (ex: ParseException) {
                ex.printStackTrace()
            }

            return date != null
        }
    }
}