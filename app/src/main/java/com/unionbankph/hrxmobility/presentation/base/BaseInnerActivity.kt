package com.unionbankph.hrxmobility.presentation.base

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.factory.DialogFactory
import kotlinx.android.synthetic.main.layout_hrx_toolbar.*


abstract class BaseInnerActivity<V : MvpView, P : BasePresenter<V>> :
    AppCompatActivity(),
    MvpView {

    abstract val viewRes: Int

    abstract fun getPresenter(): P

    abstract fun getView(): V

    abstract val activitTitle: String

    abstract val activitySubTitle: String

    abstract val toolbarSupport: Boolean

    abstract fun initViews(savedInstanceState: Bundle?)

    private var loadingDialog: Dialog? = null
    private val dialogs = arrayListOf<Dialog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewRes)
        if (!getPresenter().isViewAttached) {
            getPresenter().attachView(getView())
        }

        initViews(savedInstanceState)


    }


    override fun onPause() {
        cleanUpDialogs()
        super.onPause()
        if (!getPresenter().isViewAttached) {
            getPresenter().attachView(getView())
        }
    }

    override fun onDestroy() {
        cleanUpDialogs()

        if (getPresenter().isViewAttached) {
            getPresenter().detachView()
        }

        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        if (!getPresenter().isViewAttached) {
            getPresenter().attachView(getView())
        }
    }

    override fun onResume() {
        super.onResume()
        if (!getPresenter().isViewAttached) {
            getPresenter().attachView(getView())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        getPresenter().detachView()
        super.onSaveInstanceState(outState)
    }

    override fun showLoading(message: String) {
        if (!isFinishing) {
            if (loadingDialog == null) {
                loadingDialog = DialogFactory.createProgressDialog(this, message)

                loadingDialog!!.show()
            } else {
                if (!loadingDialog!!.isShowing) {
                    loadingDialog!!.show()
                } else { //if loading is showing, update the text
                    (loadingDialog!!.findViewById(R.id.tv_message) as AppCompatTextView).text = message
                }
            }
        }
    }

    override fun showLoading() {
        showLoading(getString(R.string.loading))
    }

    override fun hideLoading() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }

    override fun noInternetConnection() {
        val dialog = DialogFactory.createGenericErrorDialog(this, "Please check your internet connection")
        dialogs.add(dialog)
        dialog.show()
    }

    fun showGenericErrorDialog(message: String) {
        if (!isFinishing) {
            val dialog = DialogFactory.createGenericErrorDialog(this, message)
            dialogs.add(dialog)
            dialog.show()
        }
    }

    override fun showLogout() {
        val dialog = DialogFactory.createErrorDialog(this,
            "Error", "Please re-login, token session has expired.")
        dialog.show()
    }

    fun showGenericErrorDialog(stringRes: Int) {
        if (!isFinishing) {
            val dialog = DialogFactory.createGenericErrorDialog(this, stringRes)
            dialogs.add(dialog)
            dialog.show()
        }
    }

    fun showErrorDialog(title: String, message: String) {
        if (!isFinishing) {
            val dialog = DialogFactory.createErrorDialog(this, title, message)
            dialogs.add(dialog)
            dialog.show()
        }
    }

    fun showErrorDialog(titleRes: Int, stringRes: Int) {
        if (!isFinishing) {
            val dialog = DialogFactory.createErrorDialog(this, titleRes, stringRes)
            dialogs.add(dialog)
            dialog.show()
        }
    }

    private fun cleanUpDialogs() {
        for (dialog in dialogs) {
            if (dialog.isShowing) {
                dialog.cancel()
            }
        }

        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.cancel()
        }

    }
}