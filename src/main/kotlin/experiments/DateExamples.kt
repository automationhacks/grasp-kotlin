package main.kotlin.experiments

import java.text.SimpleDateFormat
import java.util.*


fun main(args: Array<String>) {
    val utils = DateUtils()
    println(utils.getTimeStampForToday())
    println(utils.getTimeStampForTodayPlus(2))
}

class DateUtils {
    val TIME_STAMP_PATTERN = "yyyy-MM-dd HH:mm:ss+05:30"

    fun getTimeStampForToday(): String {
        val date = getFormattedDateTime(Date())
        return getTimeStamp(date)
    }

    fun getTimeStampForTodayPlus(daysToAdd: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, daysToAdd)

        val timeStamp = getFormattedDateTime(calendar.time)
        return getTimeStamp(timeStamp)
    }

    private fun getFormattedDateTime(date: Date) = SimpleDateFormat(TIME_STAMP_PATTERN).format(date)

    private fun getTimeStamp(timeStamp: String): String {
        val timeSplit = timeStamp.split(" ")
        return "${timeSplit[0]}T${timeSplit[1]}"
    }
}

