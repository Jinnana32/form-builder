package com.unionbankph.hrxmobility.data.interceptor

import com.unionbankph.hrxmobility.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class IBMInterceptor() : Interceptor{

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.addHeader("Content-Type", "application/json")
        builder.addHeader("accept", "application/json")

        return chain.proceed(builder.build())
    }

}