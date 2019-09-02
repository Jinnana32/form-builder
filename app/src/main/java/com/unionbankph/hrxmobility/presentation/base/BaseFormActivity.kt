package com.unionbankph.hrxmobility.presentation.base

import android.annotation.SuppressLint
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.ViewUtil
import kotlinx.android.synthetic.main.activity_base_form.*
import kotlinx.android.synthetic.main.layout_form_summary_footer.view.*
import kotlinx.android.synthetic.main.layout_hrx_toolbar.*

/**
 * Handles the basic method and layout for a form.
 * It inserts button like continue, edit and submit button, and its basic behavior.
 */
abstract class BaseFormActivity<V : BaseFormMvpView, P : BaseFormPresenter<V>> : BaseActivity<V, P>() , BaseFormMvpView
{
    abstract fun getFormScrollView(): NestedScrollView?

    abstract fun getFormView(): View?

    abstract fun getFormPresenter(): BaseFormPresenterInterface?

    abstract val activitTitle: String

    abstract val activitySubTitle: String

    abstract val toolbarSupport: Boolean

    override fun disableForm() {
        layout_form_summary_footer.visibility = View.VISIBLE
        btn_continue.visibility = View.GONE

        if (getFormScrollView() != null) {
            getFormScrollView()?.post {
                getFormScrollView()?.fling(0)
                getFormScrollView()?.smoothScrollTo(0, 0)

                ViewUtil.setViewAndChildrenEnabled(getFormView()!!, false)
            }
        } else {
            ViewUtil.setViewAndChildrenEnabled(getFormView()!!, false)
        }
    }

    override fun enableForm() {
        layout_form_summary_footer.visibility = View.GONE
        btn_continue.visibility = View.VISIBLE

        ViewUtil.setViewAndChildrenEnabled(getFormView()!!, true)
    }

    /**
     * Inserts the layout for a form.
     */
    override fun setContentView(layoutResID: Int) {
        @SuppressLint("InflateParams")
        val activityBaseForm = layoutInflater.inflate(R.layout.activity_base_form, null) as ConstraintLayout

        val frameBaseForm = activityBaseForm.findViewById<FrameLayout>(R.id.frame_base_form)

        layoutInflater.inflate(layoutResID, frameBaseForm, true)

        super.setContentView(activityBaseForm)

        layout_form_summary_footer.btn_submit_leave.setOnClickListener { getFormPresenter()?.submitForm() }
        btn_continue.setOnClickListener { getFormPresenter()?.submitFormReview() }
        layout_form_summary_footer.btn_edit.setOnClickListener { getFormPresenter()?.editForm() }

    }

}