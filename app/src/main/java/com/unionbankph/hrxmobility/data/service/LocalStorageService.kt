package com.unionbankph.hrxmobility.data.service

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.unionbankph.hrxmobility.data.util.Encryption
import io.reactivex.Completable
import io.reactivex.Single

class LocalStorageService(private val context: Context,
                          private val gson:Gson) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    fun saveKey(key: String, value: Any) {
        sharedPreferences.edit()
            .putString(key, value.toString())
            .apply()
    }

    fun <T> getKey(key: String,  classType: Class<T>) : T {

        if(sharedPreferences.contains(key)){
            val value = sharedPreferences.getString(key, "")
            val obj = gson.fromJson(value, classType)

            return obj
        }

        return gson.fromJson("", classType)
    }

    fun getKey(key: String) : String{
        if(sharedPreferences.contains(key)){
            return sharedPreferences.getString(key, "")!!
        }

        return ""
    }

}