package com.ubx.identity.data.factory

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import java.security.GeneralSecurityException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager


object SslClientFactory {
    val okHttpClientBuilder: OkHttpClient.Builder
        get() {
            val httpClient = OkHttpClient.Builder()

            try {
                httpClient.sslSocketFactory(TlsSocketFactory(), object : X509TrustManager {
                    override fun getAcceptedIssuers(): Array<X509Certificate?> {
                        return arrayOfNulls(0)
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(x509Certificates: Array<X509Certificate>, s: String) {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(x509Certificates: Array<X509Certificate>, s: String) {
                    }
                })
            } catch (e: GeneralSecurityException) {
                throw RuntimeException(e)
            }

            return httpClient
        }
}
