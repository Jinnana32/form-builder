package com.unionbankph.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class HrxButtonList : AppCompatButton {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, R.attr.listButtonStyle) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(context: Context, attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UBListButton)

        try {
            val leftIcon = a.getResourceId(R.styleable.UBListButton_leftIcon, 0)
            val rightIcon = a.getResourceId(R.styleable.UBListButton_rightIcon, R.drawable.ub_ic_arrow_right)
            setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.xl_padding))
            setCompoundDrawablesWithIntrinsicBounds(leftIcon, 0, rightIcon, 0)
        } finally {
            a.recycle()
        }
    }
}