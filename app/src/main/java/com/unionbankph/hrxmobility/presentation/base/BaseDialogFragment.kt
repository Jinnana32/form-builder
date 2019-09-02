package com.unionbankph.hrxmobility.presentation.base

import android.app.Dialog
import androidx.fragment.app.DialogFragment
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.factory.DialogFactory


abstract class BaseDialogFragment<V : MvpView, P : BasePresenter<V>> : DialogFragment(), MvpView {

    private var loadingDialog: Dialog? = null

    val baseActivity: BaseActivity<V, P>
        get() = activity as BaseActivity<V, P>

    override fun showError(throwable: Throwable) {
       DialogFactory.createGenericErrorDialog(context!!, R.string.error_generic).show()
    }

    override fun noInternetConnection() {
      DialogFactory.createGenericErrorDialog(context!!, R.string.error_network).show()
    }

    override fun showLogout() {

       val dialog = DialogFactory.createMessageDialog(context!!,
                getString(R.string.error_session_expired_title),
                getString(R.string.error_session_expired_msg))

        /*dialog.setOnDismissListener { dialogInterface ->
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            baseActivity.finish()
        }*/

        dialog.show()
    }

    override fun showErrorDialog(message: String) {
        DialogFactory.createGenericErrorDialog(context!!, message).show()
    }

    override fun showLoading(message: String) {
        if (loadingDialog == null) {
          loadingDialog = DialogFactory.createProgressDialog(context!!, message)
        }

        if (!loadingDialog!!.isShowing) {
            loadingDialog!!.show()
        }
    }

    override fun showLoading() {
        showLoading(getString(R.string.dialog_loading_message))
    }

    override fun hideLoading() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }
}
