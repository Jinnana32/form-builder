package com.unionbankph.hrxmobility.presentation.util.helper


import com.unionbankph.hrx.domain.common.exception.ServerException
import com.unionbankph.hrxmobility.presentation.base.MvpView

class ServerErrorHelper internal constructor(mvpView: MvpView?, throwable: ServerException)
    : UiErrorHelper<ServerException>(mvpView!!, throwable) {

    override fun onError() {
        mvpView.showErrorDialog(throwable.message!!)
    }

    override fun getErrorMessage(): String? {
        return throwable.message
    }

}
