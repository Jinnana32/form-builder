package com.unionbankph.hrxmobility.presentation.util

import android.app.Activity
import android.content.Context
import android.content.Intent

object NavigateUtils {

        fun <T> relocate(packageContext: Context, cls: Class<T>){
            val intent = Intent(packageContext, cls)
            packageContext.startActivity(intent)
        }

        fun <T> relocate(packageContext: Context, cls: Class<T>, bundles: HashMap<String, T>) {
            val intent = Intent(packageContext, cls)
            intent.putExtra("package", bundles)
            packageContext.startActivity(intent)
        }


}