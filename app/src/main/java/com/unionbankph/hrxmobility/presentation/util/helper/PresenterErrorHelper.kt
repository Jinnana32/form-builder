package com.unionbankph.hrxmobility.presentation.util.helper

import android.util.Log

import com.unionbankph.hrx.domain.common.exception.ClientException
import com.unionbankph.hrx.domain.common.exception.ForbiddenRequestException
import com.unionbankph.hrx.domain.common.exception.GenericErrorException
import com.unionbankph.hrx.domain.common.exception.ServerException
import com.unionbankph.hrxmobility.presentation.base.BasePresenter
import com.unionbankph.hrxmobility.presentation.base.MvpView

object PresenterErrorHelper {

    fun handleOnError(basePresenter: BasePresenter<*>,
                      mvpView: MvpView,
                      e: Throwable) {
        if (basePresenter.isViewAttached) {
            mvpView.hideLoading()

            if (e is GenericErrorException) {
                GenericErrorHelper(mvpView, e).onError()
            } else if (e is ForbiddenRequestException) {
                ForbiddenErrorHelper(mvpView, e).onError()
            } else if (e is ClientException) {
                ClientErrorHelper(mvpView, e).onError()
            } else if (e is ServerException) {
                ServerErrorHelper(mvpView, e).onError()
            } else {
                mvpView.showErrorDialog("It seems that we've encountered a problem. Error: " + e.javaClass.simpleName)
            }
        }

        if (e.cause != null && e.cause!!.message != null) {
            Log.e("androidruntime", "throwable cause: " + e.cause!!.message)
        }

        if (e.message != null) {
            Log.e("androidruntime", "throwable cause: " + e.message)
        }

        Log.e("androidruntime", "error instance: " + e.javaClass.simpleName)
    }

    fun getErrorMessage(e: Throwable): String? {
        return if (e is GenericErrorException) {
            GenericErrorHelper(null!!, e).errorMessage
        } else if (e is ForbiddenRequestException) {
            ForbiddenErrorHelper(null!!, e).errorMessage
        } else if (e is ClientException) {
            ClientErrorHelper(null!!, e).errorMessage
        } else if (e is ServerException) {
            ServerErrorHelper(null, e).errorMessage
        } else {
            "It seems that we've encountered a problem. Error: " + e.javaClass.simpleName
        }
    }
}
