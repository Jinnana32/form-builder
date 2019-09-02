package com.unionbankph.hrxmobility.presentation.view.generic.login

import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.presentation.base.MvpView

interface FormMvpView : MvpView {

    fun showTemplates(templates: List<TemplateResp>)

}