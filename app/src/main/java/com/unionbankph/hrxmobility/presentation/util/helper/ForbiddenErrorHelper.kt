package com.unionbankph.hrxmobility.presentation.util.helper


import com.unionbankph.hrx.domain.common.exception.ForbiddenRequestException
import com.unionbankph.hrxmobility.presentation.base.MvpView

class ForbiddenErrorHelper(mvpView: MvpView, throwable: ForbiddenRequestException) : UiErrorHelper<ForbiddenRequestException>(mvpView, throwable) {

    override fun onError() {
        mvpView.showLogout()
    }

    override fun getErrorMessage(): String {
        return "Session Expired. Redirecting to login..."
    }
}
