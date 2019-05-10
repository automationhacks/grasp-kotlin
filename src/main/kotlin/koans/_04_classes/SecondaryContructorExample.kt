package koans._04_classes

// Reference: https://kotlinlang.org/docs/reference/classes.html?_ga=2.42613741.91107089.1557227061-2114576280.1553576364

/**
 * A class can have secondary constructor defined in kotlin
 * It must always delegate to primary constructor. This can be done by using this keyword
 */
class Chair(val seatType: String) {
    /**
     * All init blocks of primary constructor are called before secondary constructor call
     * Since delegation to primary happens as the first statement in secondary constructor call
     */

    init {
        println("Init block of primary constructor called ...")
        println("seat type = $seatType")
    }

    constructor(seatType: String, qty : Int) : this(seatType) { // here : this(seatType) is delegating to primary constructor
        print("Inside secondary constructor ----> ")
        println("seat=$seatType quantity=$qty")
    }

    init {
        println("Init block end of primary constructor called ...")
    }
}

// For a class with no primary or secondary constructor, a default constructor with no parameters is
// created automatically.
class Atom


fun main(args : Array<String>) {
    Chair("Soft material")
    println("===== END of first object creation ======")
    Chair("Leather", 1)

    // Can create object of Atom
    Atom()
}