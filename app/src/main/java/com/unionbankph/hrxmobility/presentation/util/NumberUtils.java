package com.unionbankph.hrxmobility.presentation.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Number Util
 * Created by Tenten Ponce on 8/27/2017.
 */

public class NumberUtils {

    public static final String PESO_SIGN = "\u20B1";

    public static String formatTwoDecimal(double d) {
        NumberFormat numberFormat = new DecimalFormat("#,##0.00");

        return numberFormat.format(d);
    }
}
