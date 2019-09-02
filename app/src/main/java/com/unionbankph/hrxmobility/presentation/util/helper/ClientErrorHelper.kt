package com.unionbankph.hrxmobility.presentation.util.helper

import android.util.Log

import com.unionbankph.hrx.domain.common.exception.ClientException
import com.unionbankph.hrxmobility.presentation.base.MvpView

class ClientErrorHelper internal constructor(mvpView: MvpView, throwable: ClientException) : UiErrorHelper<ClientException>(mvpView, throwable) {

    override fun onError() {
        Log.e("androidruntime", "throwable cause: " + throwable.cause!!.message)

        mvpView.showErrorDialog(throwable.message!!)
    }

    override fun getErrorMessage(): String? {
        Log.e("androidruntime", "throwable cause: " + throwable.cause!!.message)

        return throwable.message
    }
}

