package com.unionbankph.hrxmobility.data.interceptor

import android.content.Context
import android.net.ConnectivityManager
import com.ubx.identity.domain.common.exception.NoNetworkException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo

        val isConnected = activeNetwork != null && activeNetwork.isConnected

        if (!isConnected) {
            throw NoNetworkException()
        }

        return chain.proceed(chain.request())
    }
}