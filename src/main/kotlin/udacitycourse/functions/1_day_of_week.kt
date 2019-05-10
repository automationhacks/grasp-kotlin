package udacitycourse.functions

import java.util.*

/**
 * Basic Task

Create a new Kotlin file.
Copy and paste the main() function from Hello World into the file.
Create a new function, dayOfWeek().
In the body of the function, print "What day is it today?"
Call dayOfWeek() from main().
Run your program.


 */

fun main(args: Array<String>) {
    dayOfWeek()
}



/**
Extended Task

In the body of the dayOfWeek() function, answer the question by printing the current day of the week.
Hints

You can use Java libraries (java.util) from Kotlin. For example, to get the day of the week:

Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

Type in the code, then press Option + Enter in Mac, or Alt + Enter in Windows, over the red Calendar class to import the library.
Use a when statement to print a string depending on the day. Sunday is the first day of the week.
 */

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    println(when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        else -> "Something went wrong."
    })
}
