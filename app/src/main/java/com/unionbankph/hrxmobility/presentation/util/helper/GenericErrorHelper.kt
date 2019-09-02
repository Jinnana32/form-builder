package com.unionbankph.hrxmobility.presentation.util.helper

import android.util.Log
import com.unionbankph.hrx.domain.common.exception.GenericErrorException
import com.unionbankph.hrxmobility.domain.common.exception.ErrorsItem
import com.unionbankph.hrxmobility.presentation.base.MvpView

class GenericErrorHelper(mvpView: MvpView,
                         throwable: GenericErrorException) : UiErrorHelper<GenericErrorException>(mvpView, throwable) {

    override fun onError() {
        val errorResp:ErrorsItem = throwable.errorResp
        val errorList: String = errorResp.message!!
        if (!(errorList == null || errorList.isEmpty())) {
            mvpView.showErrorDialog(errorList)
        } else {
            mvpView.showErrorDialog("It seems that we've encountered a problem. Error: " + throwable.javaClass.simpleName)
        }
    }

    override fun getErrorMessage(): String {
        val errorResp = throwable.errorResp
        val errorList: String? = errorResp.message!!

        return if (!(errorList == null || errorList.isEmpty())) {
            throwable.errorResp.message!!
        } else {
            "It seems that we've encountered a problem. Error: " + throwable.javaClass.simpleName
        }
    }

}
