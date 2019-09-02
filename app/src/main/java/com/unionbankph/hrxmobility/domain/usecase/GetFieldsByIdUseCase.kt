package com.unionbankph.hrxmobility.domain.usecase

import com.ubx.identity.domain.base.SingleUseCase
import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import com.unionbankph.hrxmobility.domain.resp.FieldResp
import com.unionbankph.hrxmobility.domain.respository.FormRepository
import io.reactivex.Single

class GetFieldsByIdUseCase(
    postExecutionThread: PostExecutionThread,
    private val formRepository: FormRepository
) : SingleUseCase<List<FieldResp>, String>(postExecutionThread) {

    override fun buildObservable(param: String): Single<List<FieldResp>> {
        return formRepository.getFieldsById(param)
    }

}