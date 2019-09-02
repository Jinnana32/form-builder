package com.ubx.identity.domain.base

import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<Param>(
    private val postExecutionThread: PostExecutionThread
) {

    abstract fun buildObservable(param: Param): Completable

    fun execute(param: Param): Completable {
        return buildObservable(param)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }
}
