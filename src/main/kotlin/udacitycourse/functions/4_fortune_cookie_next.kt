package main.kotlin.udacitycourse.functions

/**
 * Practice Time

Use the code you created in the last practice, or copy the starter code from below.

The getFortune() function should really only be getting the fortune, and not be in the business of getting the birthday.

Change your Fortune Cookie program as follows:

Create a function called getBirthday() that gets the birthday from the user.
Pass the result of getBirthday() to getFortune() using an Integer argument, and use it to return the correct fortune.
Remove getting the birthday from getFortune()
Instead of calculating the fortune based on the birthday, use a when statement to assign some fortunes as follows (or use your own conditions):
If the birthday is 28 or 31...
If the birthday is in the first week…
else … return the calculated fortune as before.

Hint: There are several ways in which to make this when statement. How much can you Kotlinize it?
 */

fun main(args: Array<String>) {
    var i = 0
    while(i < 3) {
        val birthday = getBirthday()
        println(" ")
        val results = getFortune(birthday)

        if (results.contains("Take it easy")) {
            println(results)
            break
        } else {
            println("Your fortune is: $results")
        }
        i++
    }
}

fun getFortune(birthday: Int): String {
    val cookies = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )



    return cookies[when (birthday) {
        in 28..31 -> 3
        else -> birthday.rem(cookies.size)
    }]
}

private fun getBirthday(): Int {
    print("\nPlease Enter your birthday : ")
    return readLine()?.toIntOrNull() ?: 1
}
