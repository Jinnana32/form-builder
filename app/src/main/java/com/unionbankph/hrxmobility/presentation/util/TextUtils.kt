package com.unionbankph.hrxmobility.presentation.util

object TextUtils {

    fun getInitials(name: String): String{
        val nameArr = name.split(" ")
        var initials = ""
        nameArr.forEach {
            initials += it.substring(0,1)
        }
        return initials
    }

}