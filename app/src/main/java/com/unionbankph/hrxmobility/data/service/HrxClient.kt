package com.unionbankph.hrxmobility.data.service


import com.google.gson.Gson
import com.unionbankph.hrxmobility.data.common.helper.ResponseHelper
import com.unionbankph.hrxmobility.data.params.LoginParams
import com.unionbankph.hrxmobility.data.params.timekeeping.DtrParams
import com.unionbankph.hrxmobility.data.params.timekeeping.HasIn
import com.unionbankph.hrxmobility.data.params.timekeeping.TimeInParam
import com.unionbankph.hrxmobility.domain.resp.*
import com.unionbankph.hrxmobility.domain.resp.timekeeping.DTR
import io.reactivex.Single

class HrxClient(
    private val service: HrxService,
    private val mResponseHelper: ResponseHelper,
    private val gson: Gson
) {

    fun getTemplates() : Single<List<TemplateResp>>{
        return service.getTemplates()
            .compose(mResponseHelper.errorHandler())
    }

    fun getFieldsById(template_id: String) : Single<List<FieldResp>>{
        return service.getFieldsById(template_id)
            .compose(mResponseHelper.errorHandler())
    }

}

