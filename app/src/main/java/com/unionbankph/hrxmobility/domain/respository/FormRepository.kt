package com.unionbankph.hrxmobility.domain.respository

import com.unionbankph.hrxmobility.data.params.LoginParams
import com.unionbankph.hrxmobility.domain.resp.FieldResp
import com.unionbankph.hrxmobility.domain.resp.LoginResp
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import io.reactivex.Single

interface FormRepository {

    fun getTemplates() : Single<List<TemplateResp>>

    fun getFieldsById(template_id: String) : Single<List<FieldResp>>

}