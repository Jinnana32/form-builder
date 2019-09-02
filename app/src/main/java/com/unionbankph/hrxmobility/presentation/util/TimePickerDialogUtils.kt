package com.unionbankph.hrxmobility.presentation.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class TimePickerDialogUtils {

    companion object {

        var nString:String =""


        /*fun showTimepicker(context: Context?, edit_text:Button) : String{
            var formattedTime : String? = null

            val timePickerDialog = TimePickerDialog(context, R.style.Theme_Holo_Light_Dialog,
                TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minutes ->
                    var timeZone: String = if(hourOfDay >= 12) "PM" else "AM"

                    formattedTime  =  String.format("%02d:%02d", hourOfDay, minutes)+ timeZone

                }, 0, 0, false



            )


            timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            timePickerDialog.cancel()
            timePickerDialog.show()

            return formattedTime
        }*/

        fun convetTimeFormat(time: String): String {

            var newDate:String = time.substring(0,time.length-2)

           lateinit var dateObj: Date

            try {
                val sdf = SimpleDateFormat("H:mm")
                dateObj = sdf.parse(newDate)
                System.out.println(dateObj)

            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return SimpleDateFormat("K:mm").format(dateObj)
        }


    }
}