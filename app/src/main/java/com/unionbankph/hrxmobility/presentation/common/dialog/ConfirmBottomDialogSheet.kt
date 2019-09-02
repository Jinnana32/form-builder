package com.unionbankph.hrxmobility.presentation.common.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itsgmobility.hrbenefits.ui.UBButton
import kotlinx.android.synthetic.main.dialog_confirm_bottomsheet.view.*

class ConfirmBottomDialogSheet: BottomSheetDialogFragment() {

    companion object {

        fun newInstance() : ConfirmBottomDialogSheet {
            val dialog = ConfirmBottomDialogSheet()
            return dialog
        }

    }

    // Setup Continue button click listener
    private lateinit var mEditBtn: UBButton
    private lateinit var mDeleteBtn: UBButton
    private lateinit var mCancelBtn: UBButton

    private var mEditListener : ConfirmEdit? = null
    private var mDeleteListener : ConfirmDelete? = null

    interface ConfirmEdit {
        fun onEdit()
    }

    interface ConfirmDelete {
        fun onDelete()
    }

    fun withEditOnClick(listener: ConfirmEdit) : ConfirmBottomDialogSheet {
        mEditListener = listener
        return this
    }

    fun withDeleteOnClick(listener: ConfirmDelete) : ConfirmBottomDialogSheet {
        mDeleteListener = listener
        return this
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        // Init dialog behaviour
        dialog.setOnShowListener { dd ->
            val d = dd as BottomSheetDialog

            val bottomSheet = d.findViewById<FrameLayout>(R.id.design_bottom_sheet)
            bottomSheet!!.setBackgroundResource(android.R.color.transparent)
            if (bottomSheet != null) {
                BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
                /*BottomSheetBehavior.from(bottomSheet).setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                            dismiss()
                        }
                    }

                    override fun onSlide(@NonNull bottomSheet: View, slideOffset: Float) {}
                })*/
            }
        }

        // Init Dialog Content
        val contentView = View.inflate(context, com.unionbankph.hrxmobility.R.layout.dialog_confirm_bottomsheet, null)
        dialog.setContentView(contentView)

        mEditBtn = contentView.btn_edit
        mDeleteBtn = contentView.btn_delete
        mCancelBtn = contentView.btn_cancel

        mEditBtn.setOnClickListener{view ->
            mEditListener!!.onEdit()
            dialog.dismiss()
        }
        mDeleteBtn.setOnClickListener{view ->
            mDeleteListener!!.onDelete()
            dialog.dismiss()
        }
        mCancelBtn.setOnClickListener { dismiss() }

        return dialog
    }
}