package com.unionbankph.hrxmobility.presentation.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import androidx.core.content.ContextCompat.getSystemService
import java.net.NetworkInterface
import java.util.*


class MacAddressUtils {
    companion object {

        fun getMacAddress(): String? {
            try {
                val all = Collections.list(NetworkInterface.getNetworkInterfaces())
                for (nif in all) {
                    if (!nif.getName().equals("wlan0", ignoreCase=true)) continue

                    val macBytes = nif.getHardwareAddress() ?: return ""

                    val res1 = StringBuilder()
                    for (b in macBytes) {
                        //res1.append(Integer.toHexString(b & 0xFF) + ":");
                        res1.append(String.format("%02X:", b))
                    }

                    if (res1.length > 0) {
                        res1.deleteCharAt(res1.length - 1)
                    }
                    return res1.toString()
                }
            } catch (ex: Exception){

            }

            return null
            //"02:00:00:00:00:00"
        }
    }
}