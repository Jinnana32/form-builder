package com.unionbankph.hrxmobility.presentation.view.generic.login

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.domain.resp.TemplateResp
import com.unionbankph.hrxmobility.presentation.base.BaseActivity
import com.unionbankph.hrxmobility.presentation.common.adapter.FormTemplateAdapterItem
import com.unionbankph.hrxmobility.presentation.util.factory.DialogFactory
import com.unionbankph.hrxmobility.presentation.view.generic.form.FormDetailActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject


class FormActivity :
    BaseActivity<FormMvpView, FormPresenter>(),
    FormMvpView {

    private lateinit var formTemplateAdapter : FastItemAdapter<FormTemplateAdapterItem>

    /* Init References */
    val mPresenter: FormPresenter by inject()

    override fun getPresenter(): FormPresenter = mPresenter

    override fun getView(): FormMvpView = this

    override val viewRes: Int
        get() = R.layout.activity_login

    override fun initViews(savedInstanceState: Bundle?) {

        formTemplateAdapter = FastItemAdapter()

        formTemplateAdapter.withOnClickListener { v, adapter, item, position ->
            startActivity(FormDetailActivity.getStartIntent(this@FormActivity, item.model.id.toString(), item.model.label!!))
            true
        }

        rv_form_templates.layoutManager = LinearLayoutManager(this)
        rv_form_templates.adapter = formTemplateAdapter
        rv_form_templates.isNestedScrollingEnabled = false

        mPresenter.getTemplates()
    }

    override fun showTemplates(templates: List<TemplateResp>) {
        val formTemplateAdapterItems = templates.map {
            FormTemplateAdapterItem(it)
        }
        formTemplateAdapter.clear()
        formTemplateAdapter.add(formTemplateAdapterItems)
        formTemplateAdapter.notifyAdapterDataSetChanged()
    }

    /* Error Handlers */
    override fun showError(throwable: Throwable) {
        DialogFactory.createGenericMessage(this, "Sorry", "error: ${throwable.message}").show()
    }


    override fun showLogout() {
        val dialog = DialogFactory.createErrorDialog(this,
            "Error", "Message: Request unauthorized")
        dialog.show()
    }


    override fun showErrorDialog(message: String) {
        DialogFactory.createGenericMessage(this, "Sorry", message).show()
    }

}