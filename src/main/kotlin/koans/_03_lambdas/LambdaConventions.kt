package main.kotlin.koans._03_lambdas


/**
 * Here foo is a higher order function as it accepts a lambda as an parameter
 * Which accepts an Int and returns an Int value
 * Reference: https://kotlinlang.org/docs/reference/lambdas.html?_ga=2.247788483.553776541.1556815188-2114576280.1553576364#passing-a-lambda-to-the-last-parameter
 */
fun foo(number: Int, func: (Int) -> Int) {
    println("No : $number and value from func : ${func(number)}")
}

// bar is a func with a single lambda as the parameter
fun bar(salary: (Double) -> Double) {
    println("The final salary after adjustment is : ${salary(2.5)}")
}

fun fooBar() {
    val names = listOf("Tony", "Steve", "Natasha")
    // Concept: If compiler can figure out the signature itself then -> is not required in the lambda
    // Here it can figure out that it.length is Int and hence a -> convention is not required
    println(names.filter { it.length > 5 })
}

fun main(args: Array<String>) {
    /*
    In Kotlin there is a convention:
    If a function accepts a Lambda as last parameter then we can specify the lambda outside the parenthesis
    In the call.
     */
    foo(2) { it * 4 }

    // If lambda is the only parameter then the parenthesis can be altogether skipped in the call.
    bar { it * 2.5 }


    fooBar()
}

/**
Need to read about below:

qualified return from lambdas:
https://kotlinlang.org/docs/reference/returns.html#return-at-labels

Anonymous functions:
https://kotlinlang.org/docs/reference/lambdas.html#anonymous-functions

De-structuring declarations:
https://kotlinlang.org/docs/reference/multi-declarations.html#destructuring-in-lambdas-since-11
 */