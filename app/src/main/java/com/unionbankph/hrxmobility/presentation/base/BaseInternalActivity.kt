package com.unionbankph.hrxmobility.presentation.base

import android.annotation.SuppressLint
import androidx.appcompat.widget.LinearLayoutCompat
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.NavigateUtils.relocate
import com.unionbankph.hrxmobility.presentation.view.generic.login.FormActivity
import kotlinx.android.synthetic.main.activity_internal_layout.*
import kotlinx.android.synthetic.main.activity_internal_layout.view.*
import kotlinx.android.synthetic.main.layout_hrx_toolbar.view.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

abstract class BaseInternalActivity<V : MvpView, P : BasePresenter<V>> : BaseActivity<V, P>(),
    MvpView {

    abstract val setActivityTitle: String
    abstract val setActivitySubTitle: String?
    abstract val setToolBarHeader: String?

    // Setting the toolbars to activity
    override fun setContentView(layoutResID: Int) {
        @SuppressLint("InflateParams")
        val activityBaseForm = layoutInflater.inflate(R.layout.activity_internal_layout, null) as LinearLayoutCompat
        val frameBaseForm = activityBaseForm.frame_base_form
        layoutInflater.inflate(layoutResID, frameBaseForm, true)
        super.setContentView(activityBaseForm)

        // Header toolbar click listeners
        header_toolbar.iv_right.setOnClickListener {
            relocate(this, FormActivity::class.java)
            finish()
        }

        header_toolbar.tv_toolbar_header.text = setToolBarHeader
        // Sub Header toolbar click listeners
        subheader_toolbar.toolbar_back.setOnClickListener { onBackPressed() }
        subheader_toolbar.toolbar_tag.text = setActivityTitle
        subheader_toolbar.toolbar_sub_tag.text = setActivitySubTitle

    }

}