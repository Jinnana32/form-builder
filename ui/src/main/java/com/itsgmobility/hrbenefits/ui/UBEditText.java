package com.itsgmobility.hrbenefits.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by Exequiel Egbert V. Ponce on 7/17/2018.
 */
public class UBEditText extends AppCompatEditText {

    public UBEditText(Context context) {
        super(context);
    }

    public UBEditText(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.ubEditTextStyle);
    }
}
