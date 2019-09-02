package com.unionbankph.hrxmobility.presentation.base

interface BaseFormPresenterInterface {

    /**
     * submits the whole form to the server.
     */
    fun submitForm()

    /**
     * sets up the form for form review/summary.
     */
    fun submitFormReview()

    /**
     * reverts hrx_back the form from form review/summary to
     * be editable again.
     */
    fun editForm()
}
