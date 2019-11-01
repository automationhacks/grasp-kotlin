package idiomsDemo.kotlinIdioms._02_dataClasses

import org.testng.Assert

data class FullName(
        val first: String,
        val last: String)

fun parseName(name: String): FullName {
    val space = name.indexOf(' ')
    return FullName(
            name.substring(0, space),
            name.substring(space + 1))
}

fun main(args: Array<String>) {
    val name = parseName("Jane Doe")
    val first = name.first
    val last = name.last

    println("$first $last")

    Assert.assertEquals(first, "Jane")
    Assert.assertEquals(last, "Doe")

    if (name != parseName("Jane Doe"))
        println("Equals does not work...")
}