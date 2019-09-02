package com.unionbankph.hrxmobility.presentation.util.factory

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.TimePickerDialogUtils
import kotlinx.android.synthetic.main.dialog_confim_message.view.*
import kotlinx.android.synthetic.main.dialog_generic_message.view.*
import kotlinx.android.synthetic.main.dialog_generic_message.view.tv_dialog_message
import kotlinx.android.synthetic.main.dialog_generic_message.view.tv_dialog_title
import java.util.*


object DialogFactory {
    fun createProgressDialog(context: Context, message: String): AppCompatDialog {
        @SuppressLint("InflateParams")
        val layoutLoading = LayoutInflater.from(context).inflate(
            R.layout.layout_loading,
                null, false) as ConstraintLayout

        val tvMessage = layoutLoading.findViewById(R.id.tv_message) as AppCompatTextView
        tvMessage.text = message

        val dialog = AppCompatDialog(context)
        dialog.setCancelable(false)
        dialog.setContentView(layoutLoading)
        return dialog
    }

    fun createProgressDialog(context: Context,
                             @StringRes messageResource: Int): AppCompatDialog {
        return createProgressDialog(context, context.getString(messageResource))
    }

    fun createErrorDialog(context: Context, title: String, message: String): AppCompatDialog {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.action_ok, null)
        return alertDialog.create()
    }

    fun createErrorDialog(context: Context, @StringRes titleResource: Int, @StringRes messageResource: Int): AppCompatDialog {
        return createErrorDialog(context, context.getString(titleResource), context.getString(messageResource))
    }

    fun createGenericErrorDialog(context: Context, message: String): AppCompatDialog {
        return createErrorDialog(context, context.getString(R.string.title_error_generic), message)
    }

    fun createGenericErrorDialog(context: Context, @StringRes messageResource: Int): AppCompatDialog {
        return createGenericErrorDialog(context, context.getString(messageResource))
    }

    fun createConfirmDialog(context: Context, titleResource: Int, msgResource: Int,
                            yesListener: DialogInterface.OnClickListener): AlertDialog {
        return createConfirmDialog(context, context.getString(titleResource),
            context.getString(msgResource), yesListener)
    }

    fun createConfirmDialog(context: Context, title: String, msg: String,
                             yesListener: DialogInterface.OnClickListener): AlertDialog {
        return AlertDialog.Builder(context).setTitle(title)
            .setMessage(msg)
            .setPositiveButton("Yes", yesListener)
            .setNegativeButton("No") { dialog, id -> dialog.dismiss() }.create()
    }

    fun createConfirmDialog(context: Context, title: String, msg: String,
                            yesListener: DialogInterface.OnClickListener,
                            noListener: DialogInterface.OnClickListener): AlertDialog {
        return AlertDialog.Builder(context).setTitle(title)
            .setMessage(msg)
            .setPositiveButton("Yes", yesListener)
            .setNegativeButton("No" , noListener).create()
    }

    fun createMessageDialog(context: Context, title: String, msg: String): AlertDialog {
        return AlertDialog.Builder(context).setTitle(title)
            .setMessage(msg)
            .setPositiveButton("Ok") { dialogInterface, i -> dialogInterface.dismiss() }.create()
    }

    fun createMessageDialogWithAction(context: Context, title: String, msg: String, buttonMessage: String, yesListener: DialogInterface.OnClickListener): AlertDialog {
        return AlertDialog.Builder(context).setTitle(title)
            .setMessage(msg)
            .setPositiveButton(buttonMessage, yesListener).create()
    }

    fun createCustomListDialog(
        context: Context, drawable: Drawable?, title: String, message: String,
        choices: Array<String>, selected: Int,
        onClickListener: DialogInterface.OnClickListener
    ): AlertDialog {

        val dialog_list = LayoutInflater.from(context).inflate(R.layout.dialog_list, null, false) as LinearLayout
        val lin_list = dialog_list.findViewById<LinearLayout>(R.id.lin_list)
        val iv_dialog_icon: AppCompatImageView = dialog_list.findViewById(R.id.iv_dialog_icon)
        val tv_dialog_title: AppCompatTextView = dialog_list.findViewById(R.id.tv_dialog_title)
        val tv_dialog_description: AppCompatTextView = dialog_list.findViewById(R.id.tv_dialog_message)

        iv_dialog_icon.setImageDrawable(drawable)
        iv_dialog_icon.setColorFilter(Color.WHITE)
        tv_dialog_title.setText(title)
        tv_dialog_description.setText(message)

        val alertDialog = AlertDialog.Builder(context)
            .setView(dialog_list)
            .create()

        for (i in choices.indices) {
            val layout_custom_dialog_choice = LayoutInflater.from(context).inflate(
                R.layout.layout_custom_dialog_choice, lin_list, false
            ) as LinearLayoutCompat
            val tv_choice: AppCompatTextView = layout_custom_dialog_choice.findViewById(R.id.tv_choice)
            tv_choice.text = Html.fromHtml(choices[i])

            if (selected == i) { //check if this is the selected option
                tv_choice.setTextColor(context.applicationContext.resources.getColor(R.color.md_blue_500))
            }

            tv_choice.setOnClickListener { view -> onClickListener.onClick(alertDialog, i) }

            lin_list.addView(layout_custom_dialog_choice)
        }

        return alertDialog
    }

    fun createGenericMessage(context: Context,
                             mtitle: String,
                             mMessage: String
    ) : Dialog
    {

        // Inflate layout
        val messageBox = LayoutInflater.from(context).inflate(R.layout.dialog_generic_message, null, false) as CardView

        val dialog = Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(messageBox)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // bind views
        val title = messageBox.tv_dialog_title
        val message = messageBox.tv_dialog_message
        val confirmButton = messageBox.btn_message

        // assign values
        title.text = mtitle
        message.text = mMessage
        confirmButton.setOnClickListener { dialog.dismiss() }

        return dialog
    }

    fun createGenericMessageWithAction(context: Context,
                                       mtitle: String,
                                       mMessage: String,
                                       mConfirm: () -> Unit
    ) : Dialog
    {

        // Inflate layout
        val messageBox = LayoutInflater.from(context).inflate(R.layout.dialog_generic_message, null, false) as CardView
        val dialog = Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(messageBox)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // bind views
        val title = messageBox.tv_dialog_title
        val message = messageBox.tv_dialog_message
        val confirmButton = messageBox.btn_message

        // assign values
        title.text = mtitle
        message.text = mMessage
        confirmButton.setOnClickListener{
            mConfirm()
            dialog.dismiss()
        }

        return dialog
    }

    fun createConfirmMessage(context: Context,
                                       mtitle: String,
                                       mMessage: String,
                                       mConfirm: () -> Unit
    ) : Dialog
    {

        // Inflate layout
        val messageBox = LayoutInflater.from(context).inflate(R.layout.dialog_confim_message, null, false) as CardView

        val dialog = Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(messageBox)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // bind views
        val title = messageBox.tv_dialog_title
        val message = messageBox.tv_dialog_message
        val confirmButton = messageBox.btn_confirm
        val cancelButton = messageBox.btn_cancel

        // assign values
        title.text = mtitle
        message.text = mMessage
        confirmButton.setOnClickListener{
            mConfirm()
            dialog.dismiss()
        }
        cancelButton.setOnClickListener{ dialog.dismiss() }
        return dialog
    }

    fun calendarDialog(context: Context, listener: DatePickerDialog.OnDateSetListener) {
            val mCalendar: Calendar = Calendar.getInstance()
            val year = mCalendar.get(Calendar.YEAR)
            val month = mCalendar.get(Calendar.MONTH)
            val day = mCalendar.get(Calendar.DAY_OF_MONTH)
            val mDatePickerDialog: DatePickerDialog

            mDatePickerDialog = DatePickerDialog(context, listener, year, month, day)
            mDatePickerDialog.show()
    }

    fun timeDialog(context: Context, setTime: (time: String) -> Unit){
        val timePickerDialog = TimePickerDialog(
            context, android.R.style.Theme_Holo_Light_Dialog,
            TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minutes ->
                val timeZone: String = if (hourOfDay >= 12) "PM" else "AM"
                val formattedTime = String.format("%02d:%02d", hourOfDay, minutes) + timeZone
                val convertedTime = TimePickerDialogUtils.convetTimeFormat(formattedTime) + " " + timeZone
                setTime(convertedTime)
            }, 0, 0, false
        )

        timePickerDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.cancel()
        timePickerDialog.show()
    }


}