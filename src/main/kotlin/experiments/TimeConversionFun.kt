package experiments

import java.text.SimpleDateFormat
import java.util.*


fun main(args: Array<String>) {
    val strDate = "2018-03-14 08:16:11"
    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    df.timeZone = TimeZone.getTimeZone("UTC")
    val date = df.parse(strDate)
    println(date.time / 1000)
}

//1521015371
//1521015371000

