package com.unionbankph.hrxmobility.presentation.base

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()

}