package com.unionbankph.hrxmobility.data.util

import android.util.Base64

object Encryption {
    fun encrypt(input: Any): String {
        return Base64.encodeToString(input.toString().toByteArray(), Base64.DEFAULT)
    }

    fun decrypt(input: String): String {
        return String(Base64.decode(input, Base64.DEFAULT))
    }
}