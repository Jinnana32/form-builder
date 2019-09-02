package com.unionbankph.hrxmobility.presentation.util.validation

import android.content.Context
import android.util.Log
import com.unionbankph.hrxmobility.R
import com.unionbankph.hrxmobility.presentation.util.validation.cases.*
import java.text.DecimalFormat

object Validator {

    /**
     * iterate each validation and returns the first validation found
     *
     * @param s           string to validate
     * @param validations array of validations
     * @return first validation that is invalid
     */

    fun validate(s: Any?, validations: Array<Validation>): Validation? {

        if(s == null){
            return null
        }

        for (validation in validations) {
            if (!validation.isValid(s)) {
                return validation
            }
        }
        return null

    }

    /**
     * get the appropriate message for the validation found
     *
     * @param context    context
     * @param validation type of validation
     * @return message base on type of validation
     */
    fun getValidationText(context: Context, validation: Validation?): String? {

        if(validation == null){
            return ""
        }else {

            if (validation is RequiredValidation) {
                return context.getString(R.string.error_form_input_required)
            } else if (validation is AlphaNumericValidation) {
                return context.getString(R.string.error_alphanumeric)
            } else if (validation is YearValidation) {
                return context.getString(R.string.error_invalid_year)
            } else if (validation is AlphabetValidation) {
                return context.getString(R.string.error_alphabet)
            } else if (validation is FutureYearValidation) {
                return context.getString(R.string.error_future_year)
            } else if (validation is MaxValueValidation) {
                return String.format(
                    context.getString(R.string.error_min_max_value),
                    DecimalFormat("#.##").format(validation.max.toDouble())
                )
            } else if (validation is MinValueValidation) {
                return String.format(
                    context.getString(R.string.error_min_value),
                    DecimalFormat("#.##").format(validation.min.toDouble())
                )
            } else if (validation is MinMaxValidation) {
                return String.format(
                    context.getString(R.string.error_min_max),
                    validation.min.toString(),
                    validation.max.toString()
                )
            } else if (validation is AtleastValidation) {
                return String.format(
                    context.getString(R.string.error_min_char),
                    validation.mMin.toString()
                )
            } else if (validation is DateValidation) {
                return context.getString(R.string.error_from_to_date)
            } else if (validation is LowerCaseValidation) {
                return context.getString(R.string.error_lower_case)
            } else if (validation is UpperCaseValidation) {
                return context.getString(R.string.error_upper_case)
            } else if (validation is NumberValidation) {
                return context.getString(R.string.error_numeric_case)
            } else if (validation is SpecialCharacterValidation) {
                return context.getString(R.string.error_special_case)
            } else if (validation is EmailValidation) {
                return context.getString(R.string.error_email_not_valid)
            }
        }

        return ""

    }
}
