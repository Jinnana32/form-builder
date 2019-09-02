package com.unionbankph.hrxmobility.presentation.base

interface MvpView {

    fun showError(throwable: Throwable)

    fun noInternetConnection()

    fun showLogout()

    fun showErrorDialog(message: String)

    fun showLoading(message: String)

    fun showLoading()

    fun hideLoading()

}