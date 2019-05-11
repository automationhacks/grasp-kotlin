package koans._04_classes

/**
 * All classes in kotlin inherit from Any
 * Any is not equivalent to java.lang.Object and only has equals(), hashCode() and toString() methods
 * Refer to Java interop section to understand more: https://kotlinlang.org/docs/reference/java-interop.html#object-methods
 */

// All classes are final by default in kotlin and hence needs to be declared with open keyword
// to enable to be subclassed
// KOTLIN LIKES TO BE VERY EXPLICIT in terms of inheritance

open class Computer {
    // private to Computer, child classes cannot override this
    fun whichType() {
        println("Specific type")
    }

    // Can be overridden by child class
    open fun whichScreen() {
        println("Parent: Base classes screen type")
    }

    open fun processorType() {
        println("Parent: Generic processor")
    }

}

// To inherit use colon after class header followed by super class
// If super class has a primary constructor then child class needs to initialize it.
// https://kotlinlang.org/docs/reference/classes.html?_ga=2.208758544.308914685.1557588520-2114576280.1553576364#inheritance
// Overriding methods: https://kotlinlang.org/docs/reference/classes.html?_ga=2.208758544.308914685.1557588520-2114576280.1553576364#overriding-methods

open class Macs : Computer() {

    // In child class: override keyword is mandatory
    override fun whichScreen() {
        println("Child: Macs's retina screen...")
        super.whichScreen()
    }

    // Make a class func as final to prevent child classes to override
    // By nature override of processorType() here would be open for overriding in child class.
    final override fun processorType() {
        println("Child: Lets make final so that i cannot be overridden")
    }

}

class IMac : Macs() {
    override fun whichScreen() {
        println("2nd Level screen: IMacs large screen")
    }

    // Cannot override processorType() since it is final in Macs class

}

fun main(args: Array<String>) {
    val mac = Macs()
    mac.whichScreen()

}