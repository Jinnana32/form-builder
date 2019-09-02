package com.unionbankph.hrxmobility.di

import android.content.Context
import com.google.gson.Gson
import com.ubx.identity.data.factory.SslClientFactory
import com.unionbankph.hrxmobility.BuildConfig
import com.unionbankph.hrxmobility.data.common.helper.ResponseHelper
import com.unionbankph.hrxmobility.data.impl.DeviceRepositoryImpl
import com.unionbankph.hrxmobility.data.interceptor.IBMInterceptor
import com.unionbankph.hrxmobility.data.interceptor.NetworkInterceptor
import com.unionbankph.hrxmobility.data.service.HrxClient
import com.unionbankph.hrxmobility.data.service.HrxService
import com.unionbankph.hrxmobility.data.service.LocalStorageService
import com.unionbankph.hrxmobility.domain.respository.DeviceRepository
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {
    single { Gson() }
    single { ResponseHelper(get()) }
    single { HrxClient(get(), get(), get()) }
    single { LocalStorageService(androidContext(), get()) }
    single { createHttpClient(androidContext()) }
    single { createApiService(get(), get()).create(HrxService::class.java) }
}

fun createHttpClient( context: Context): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(NetworkInterceptor(context))
        .addInterceptor(IBMInterceptor())
        .connectTimeout(30L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60L, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(logging)
    }

    return builder.build()
}

fun createApiService(httpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .client(httpClient)
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
}