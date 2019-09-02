package com.unionbankph.hrxmobility.domain.usecase

import com.ubx.identity.domain.base.SingleUseCaseNoParam
import com.unionbankph.hrxmobility.domain.common.executor.PostExecutionThread
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.domain.respository.FormRepository
import io.reactivex.Single

class GetTemplatesUseCase(
    postExecutionThread: PostExecutionThread,
    private val formRepository: FormRepository
) : SingleUseCaseNoParam<List<TemplateResp>>(postExecutionThread) {

    override fun buildObservable(): Single<List<TemplateResp>> {
        return formRepository.getTemplates()
    }

}