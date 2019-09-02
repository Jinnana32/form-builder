package com.unionbankph.hrxmobility.di

import com.ubx.identity.presentation.common.executor.PostExecutionThreadImpl
import com.unionbankph.hrxmobility.data.impl.DeviceRepositoryImpl
import com.unionbankph.hrxmobility.data.impl.FormRepositoryImpl
import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import com.unionbankph.hrxmobility.domain.respository.DeviceRepository
import com.unionbankph.hrxmobility.domain.respository.FormRepository
import com.unionbankph.hrxmobility.domain.usecase.GetFieldsByIdUseCase
import com.unionbankph.hrxmobility.domain.usecase.GetTemplatesUseCase
import org.koin.dsl.module.module

val domainModule = module {

    /* === Executors === */
    single { PostExecutionThreadImpl() as PostExecutionThread }

    /*
   ===================================
     Repository Implementation
   ===================================
   */

    single { FormRepositoryImpl(get()) as FormRepository }
    single { DeviceRepositoryImpl(get()) as DeviceRepository }


    /*
    ==========================
        Use Cases
    ==========================
    */

    single { GetTemplatesUseCase(get(), get()) }

    single { GetFieldsByIdUseCase(get(), get()) }

}