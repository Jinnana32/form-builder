package com.unionbankph.hrxmobility.data.impl

import com.unionbankph.hrxmobility.data.service.HrxClient
import com.unionbankph.hrxmobility.domain.resp.FieldResp
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.domain.respository.FormRepository
import io.reactivex.Single

class FormRepositoryImpl(val client: HrxClient) : FormRepository {

    override fun getFieldsById(template_id: String): Single<List<FieldResp>> {
        return client.getFieldsById(template_id)
    }

    override fun getTemplates(): Single<List<TemplateResp>> {
        return client.getTemplates()
    }



}