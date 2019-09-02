package com.unionbankph.hrxmobility.presentation.view.generic.form.builder

import android.os.Bundle
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.base.BaseFragment
import com.unionbankph.hrxmobility.presentation.util.factory.DialogFactory
import org.koin.android.ext.android.inject

class FormBuilderFragment : BaseFragment<FormBuilderMvpView, FormBuilderPresenter>(), FormBuilderMvpView {

    private val mPresenter: FormBuilderPresenter by inject()

    override val viewRes: Int
        get() = R.layout.fragment_form_builder

    override fun getMvpView(): FormBuilderMvpView = this

    override fun getPresenter(): FormBuilderPresenter = mPresenter

    override fun initViews(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /* Error Handlers */
    override fun showError(throwable: Throwable) {
        DialogFactory.createGenericMessage(context!!, "Sorry", "error: ${throwable.message}").show()
    }

    override fun showErrorDialog(message: String) {
        DialogFactory.createGenericMessage(context!!, "Sorry", message).show()
    }

    override fun noInternetConnection() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLogout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}