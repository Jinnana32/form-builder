package com.unionbankph.hrxmobility.presentation.view.generic.login

import android.util.Log
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.domain.usecase.GetTemplatesUseCase
import com.unionbankph.hrxmobility.presentation.base.BasePresenter
import com.unionbankph.hrxmobility.presentation.util.helper.PresenterErrorHelper
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class FormPresenter(private val getTemplatesUseCase: GetTemplatesUseCase) :
    BasePresenter<FormMvpView>() {

    fun getTemplates(){
        getTemplatesUseCase.execute()
            .subscribe(object: SingleObserver<List<TemplateResp>>{

                override fun onSuccess(t: List<TemplateResp>) {
                  mvpView!!.showTemplates(t)
                }

                override fun onSubscribe(d: Disposable) {
                   compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    PresenterErrorHelper.handleOnError(this@FormPresenter, mvpView!!, e)
                }

            })
    }

}
