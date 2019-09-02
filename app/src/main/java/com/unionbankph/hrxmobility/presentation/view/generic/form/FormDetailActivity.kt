package com.unionbankph.hrxmobility.presentation.view.generic.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.base.BaseActivity
import com.unionbankph.hrxmobility.presentation.util.factory.DialogFactory
import kotlinx.android.synthetic.main.activity_form_details.*
import org.koin.android.ext.android.inject

class FormDetailActivity : BaseActivity<FormDetailMvpView, FormDetailPresenter>(), FormDetailMvpView {

    companion object {

        private const val TEMPLATE_ID = "TEMPLATE_ID"
        private const val TEMPLATE_LABEL = "TEMPLATE_LABEL"

        fun getStartIntent(context: Context, template_id: String, label: String) : Intent {
            return Intent(context, FormDetailActivity::class.java)
                .putExtra(TEMPLATE_ID, template_id)
                .putExtra(TEMPLATE_LABEL, label)
        }

    }

    val mPresenter: FormDetailPresenter by inject()

    override val viewRes: Int
        get() = R.layout.activity_form_details

    override fun getPresenter(): FormDetailPresenter = mPresenter

    override fun getView(): FormDetailMvpView = this

    override fun initViews(savedInstanceState: Bundle?) {

        val template_id = intent!!.getStringExtra(TEMPLATE_ID)
        val label = intent!!.getStringExtra(TEMPLATE_LABEL)

        title = label

        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        mPresenter.getFieldsById(template_id)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /* Error Handlers */
    override fun showError(throwable: Throwable) {
        DialogFactory.createGenericMessage(this, "Sorry", "error: ${throwable.message}").show()
    }

    override fun showErrorDialog(message: String) {
        DialogFactory.createGenericMessage(this, "Sorry", message).show()
    }

}