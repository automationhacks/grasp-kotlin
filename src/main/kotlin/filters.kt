package main.kotlin

/**
 * Practice Time

You can do the following filter exercise in REPL.

Create a list of spices, as follows:

val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

Create a filter that gets all the curries and sorts them by string length.
Hint: After you type the dot (.), IntelliJ will give you a list of functions you can apply.
Filter the list of spices to return all the spices that start with 'c' and end in 'e'. Do it in two different ways.
Take the first three elements of the list and return the ones that start with 'c'.

 */
fun main(args: Array<String>) {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    println(spices.filter { it.contains("curry") }.sortedBy { it.length })
    println(spices.filter { it.startsWith('c') && it.endsWith('e') })
    println(spices.filter { it[0] == 'c' && it[it.length - 1] == 'e' })
    println(spices.slice(0..3).filter { it.startsWith('c') })
    println(spices.take(3).filter { it.startsWith('c') })
}