package com.unionbankph.hrxmobility.presentation

import android.app.Application
import com.unionbankph.hrxmobility.di.appModule
import com.unionbankph.hrxmobility.di.dataModule
import com.unionbankph.hrxmobility.di.domainModule
import org.koin.android.ext.android.startKoin

class HrxApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(dataModule, domainModule, appModule))
    }
}