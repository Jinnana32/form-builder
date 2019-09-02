package com.unionbankph.hrxmobility.presentation.base

abstract class BaseFormPresenter<T : BaseFormMvpView> : BasePresenter<T>(), BaseFormPresenterInterface {

    /**
     * hide the continue and show the edit submit button.
     * scroll the form to top to be reviewed again.
     *
     * Override this to add validation on form
     */
    override fun submitFormReview() {
        mvpView!!.disableForm()
    }

    /**
     * re-enable form again
     */
    override fun editForm() {
        mvpView!!.enableForm()
    }
}
