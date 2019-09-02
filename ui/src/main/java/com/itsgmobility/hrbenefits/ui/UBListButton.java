package com.itsgmobility.hrbenefits.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

public class UBListButton extends AppCompatButton {

    public UBListButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.listButtonStyle);
        init(context, attrs);
    }

    public UBListButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.UBListButton);

        try {
            int leftIcon = a.getResourceId(R.styleable.UBListButton_leftIcon, 0);
            int rightIcon = a.getResourceId(R.styleable.UBListButton_rightIcon, R.drawable.ub_ic_arrow_right);
            setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.xl_padding));
            setCompoundDrawablesWithIntrinsicBounds(leftIcon, 0, rightIcon, 0);
        } finally {
            a.recycle();
        }
    }
}
