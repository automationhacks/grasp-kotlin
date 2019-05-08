package main.kotlin.koans._04_classes

/**
class declaration has keyword class followed by name and its header (type parameters and primary constructor)
If class has no body then parenthesis can be omitted altogether
 */

class Empty

/**
We can have primary constructor or one or more secondary constructors in kotlin.
Primary constructor is part of class header and written after class name and optional type parameters
 */

class Robot constructor(private val function : String)


/**
 * If primary constructor does not have any annotations or visibility modifiers then keyword
 * constructor can be skipped altogether
 */
class Person (val name : String)

/**
 * Primary constructor cannot contain any code
 * Such initialization code can be put in init {...} blocks
 * These are executed in the same order as specified in class body
 * Parameters of primary constructors can be used in init blocks or property initializer's also
 */
class Weather(val city : String) {
    // Here we are using city which is a parameter in primary constructor in a property.
    val firstProperty = "Weather details for $city".also(::println)

    init {
        println("First init block -- City: $city")
    }

    val secondProperty = "Weather Code for --- $city is --- ${city.toUpperCase().substring(0 .. 3)}".also(::println)

    init {
        println("Second init block")
    }
}

/**
 * Below is a concise way in kotlin to create a class with primary constructor
 * and two properties. height is mutable hence mentioned as var and width as immutable
 * hence mentioned as val with a default parameter value
 */
class Room(
        var height : Int,
        val width : Int = 100
)

fun main(args : Array<String>) {
    val weather = Weather("Bangalore")
}
