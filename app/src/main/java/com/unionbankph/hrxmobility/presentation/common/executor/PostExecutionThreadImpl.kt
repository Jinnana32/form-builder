package com.ubx.identity.presentation.common.executor

import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class PostExecutionThreadImpl : PostExecutionThread {
    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}