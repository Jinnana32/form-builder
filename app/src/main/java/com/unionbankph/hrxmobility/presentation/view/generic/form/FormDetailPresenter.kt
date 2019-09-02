package com.unionbankph.hrxmobility.presentation.view.generic.form

import android.util.Log
import com.unionbankph.hrxmobility.domain.resp.FieldResp
import com.unionbankph.hrxmobility.domain.usecase.GetFieldsByIdUseCase
import com.unionbankph.hrxmobility.presentation.base.BasePresenter
import com.unionbankph.hrxmobility.presentation.util.helper.PresenterErrorHelper
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class FormDetailPresenter(
    private val mGetFieldsByIdUseCase: GetFieldsByIdUseCase
)
    : BasePresenter<FormDetailMvpView>() {

    fun getFieldsById(template_id: String){
        mGetFieldsByIdUseCase.execute(template_id)
            .subscribe(object : SingleObserver<List<FieldResp>>{

                override fun onSuccess(t: List<FieldResp>) {
                    Log.e("Androidruntime", "Fields ${t}")
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    PresenterErrorHelper.handleOnError(this@FormDetailPresenter, mvpView!!, e)
                }


            })
    }

}