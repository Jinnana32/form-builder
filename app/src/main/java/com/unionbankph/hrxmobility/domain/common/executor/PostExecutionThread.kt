package com.unionbankph.hrxmobility.domain.common.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}