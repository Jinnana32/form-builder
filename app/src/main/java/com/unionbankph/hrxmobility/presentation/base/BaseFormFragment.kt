package com.unionbankph.hrxmobility.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView

/**
 * Handles the basic method and layout for a form.
 * It inserts button like continue, edit and submit button, and its basic behavior.
 */
abstract class BaseFormFragment<V : MvpView, P : BasePresenter<V>>  : BaseFragment<V, P>(),
    BaseFormMvpView {

    override abstract fun getPresenter(): P

    override abstract fun getMvpView(): V

    abstract fun getFormScrollView(): NestedScrollView?

    abstract fun getFormView(): View

    override fun disableForm() {
    }

    override fun enableForm() {
    }

    /**
     * layout for the fragment
     */
    abstract fun layoutResourceId(): Int

    /**
     * Inserts the layout for a form.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}