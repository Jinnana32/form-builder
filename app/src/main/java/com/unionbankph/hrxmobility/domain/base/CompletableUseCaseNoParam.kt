package com.ubx.identity.domain.base

import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCaseNoParam(
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract fun buildObservable(): Completable

    fun execute(): Completable {
        return buildObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }
}
