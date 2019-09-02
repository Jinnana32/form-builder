package com.unionbankph.hrxmobility.presentation.util.helper

import com.unionbankph.hrxmobility.presentation.base.MvpView
import com.unionbankph.hrxmobility.presentation.util.helper.ErrorHelper

import java.lang.ref.WeakReference

abstract class UiErrorHelper<T : Exception> internal constructor(mvpView: MvpView,
                                                                 throwable: T) : ErrorHelper<T>(throwable) {

    private val mvpViewWeakReference: WeakReference<MvpView>

    internal val mvpView: MvpView
        get() = mvpViewWeakReference.get()!!

    init {

        mvpViewWeakReference = WeakReference(mvpView)
    }

    abstract fun onError()
}
