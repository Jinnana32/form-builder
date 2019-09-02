package com.ubx.identity.domain.base

import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCaseNoParam<Return>(
    private val postExecutionThread: PostExecutionThread
) {

    abstract fun buildObservable(): Single<Return>

    fun execute(): Single<Return> {
        return buildObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }
}
