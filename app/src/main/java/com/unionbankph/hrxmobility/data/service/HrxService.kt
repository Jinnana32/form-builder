package com.unionbankph.hrxmobility.data.service


import com.unionbankph.hrxmobility.data.params.LoginParams
import com.unionbankph.hrxmobility.data.params.timekeeping.HasIn
import com.unionbankph.hrxmobility.data.params.timekeeping.TimeInParam
import com.unionbankph.hrxmobility.domain.resp.*
import com.unionbankph.hrxmobility.domain.resp.timekeeping.DTR
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface HrxService {

    /* User flow */
    @GET("templates")
    fun getTemplates(): Single<Response<List<TemplateResp>>>

    @GET("fields/{template_id}")
    fun getFieldsById(@Path("template_id") template_id: String): Single<Response<List<FieldResp>>>

}