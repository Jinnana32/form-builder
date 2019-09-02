package com.unionbankph.hrxmobility.presentation.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


object DateFormatUtils {

    var nString: String = ""

    fun newDateFormatter(string: String, isLanient: Boolean): String {
        val fmt = SimpleDateFormat("MM-dd-yyyy")
        fmt.isLenient = isLanient
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("MMM dd, yyyy")
        return fmtOut.format(date)
    }

    fun dateFormatter(string: String): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("MMM dd, yyyy")
        return fmtOut.format(date)
    }

    fun dateFormatter(currDate: Date, pattern: String): String {
        val fmtOut = SimpleDateFormat(pattern)
        return fmtOut.format(currDate)
    }

    fun getValidDate(month: Int, day: Int, year: Int) : String{
        val newMonth = month + 1
        val currMonth :String = if(newMonth < 10) "0$newMonth" else newMonth.toString()
        val currDay :String = if(day < 10) "0$day" else day.toString()
        return "$currMonth $currDay ${year}"
    }

    fun getFirstDayOfWeek(){

    }

    fun getDaysOfWeek(refDate: Date, firstDayOfWeek: Int): List<Date> {
        val calendar = Calendar.getInstance()
        calendar.time = refDate
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek)
        val daysOfWeek = arrayOfNulls<Date>(7)
        for (i in 0..6) {
            daysOfWeek[i] = calendar.time
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        return daysOfWeek.map { it!! }
    }

    fun getDateToday(format: String): String {
        val sdf = SimpleDateFormat(format)
        val currentDate = sdf.format(Date())
        return currentDate
    }

    fun getTimeNow(): String {
        val sdf = SimpleDateFormat("hh:mm")
        val currentDate = sdf.format(Date())
        return currentDate
    }

    fun getTimeZone(): String {
        val sdf = SimpleDateFormat("a")
        val currentDate = sdf.format(Date())
        return currentDate
    }

    fun formatUTC(currentDate: String, format: String) : String {
        val fmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        fmt.timeZone = TimeZone.getTimeZone("UTC");
        val date = fmt.parse(currentDate)
        Log.e("UTC date", date.toString())
        val fmtOut = SimpleDateFormat(format)
        return fmtOut.format(date)
    }

    fun fromWholeToHalftime(currentTime: String, format: String) : String {
        val wholeFormat = SimpleDateFormat("HH:mm")
        val halfFormat = SimpleDateFormat("hh:mm a")
        val fmt = SimpleDateFormat("HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        fmt.timeZone = TimeZone.getTimeZone("UTC")
        val date = fmt.parse(currentTime)
        val output = SimpleDateFormat(format)
        return output.format(date)
    }

    fun trimUtcDateToTime(time: String) : ArrayList<String> {
        val firstTrim = time.removeRange(0, 11)
        val output = firstTrim.removeRange(5, 13)
        val splitTime = output.split(":")
        val rawHr = splitTime[0].toInt()
        val temp_hr = (rawHr % 12 )
        val hr = (if(temp_hr < 10) "0$temp_hr" else temp_hr.toString())
        val min = splitTime[1]
        val zone = if(rawHr > 12) "PM" else "AM"
        return arrayListOf(hr, min, zone)
    }

    fun formatDate(date: String, format: String, pattern: String): String {
        val fmt = SimpleDateFormat(pattern)
        val date = fmt.parse(date)
        val fmtOut = SimpleDateFormat(format)
        return fmtOut.format(date)
    }

    fun dateFormatter(string: String, format: String): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("MMM dd, yyyy")
        return fmtOut.format(date)
    }

    fun dayNumberFormatter(string: String): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("dd")
        return fmtOut.format(date)
    }

    fun dayNumberFormatter(date: String, format: String): String {
        val fmt = SimpleDateFormat(format)
        val date = fmt.parse(date)

        val fmtOut = SimpleDateFormat("dd")
        return fmtOut.format(date)
    }

    fun dayWordFormmater(string: String): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("EEEE")
        return fmtOut.format(date)
    }

    fun monthYearGetter(string: String): String {
        val fmt = SimpleDateFormat("yyyy-MM-dd")
        val date = fmt.parse(string)

        val fmtOut = SimpleDateFormat("MMMM yyyy")
        return fmtOut.format(date)
    }

}
