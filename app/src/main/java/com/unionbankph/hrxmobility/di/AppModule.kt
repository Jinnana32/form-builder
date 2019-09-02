package com.unionbankph.hrxmobility.di

import com.unionbankph.hrxmobility.presentation.view.generic.form.FormDetailPresenter
import com.unionbankph.hrxmobility.presentation.view.generic.login.FormPresenter
import org.koin.dsl.module.module

val appModule = module {

    /* === Presenter === */
    single { FormPresenter(get()) }

    single { FormDetailPresenter(get()) }
}