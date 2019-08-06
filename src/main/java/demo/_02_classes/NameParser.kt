package demo._02_classes

import org.testng.Assert

fun parseName(name: String): List<String> {
    val space = name.indexOf(' ')
    return listOf(
        name.substring(0, space),
        name.substring(space + 1)
    )
}

fun main(args: Array<String>) {
    val name = parseName("Jane Doe")
    val first = name[0]
    val last = name[1]

    println("$first $last")

    Assert.assertEquals(first, "Jane")
    Assert.assertEquals(last, "Doe")
}