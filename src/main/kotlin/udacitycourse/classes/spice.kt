package main.kotlin.udacitycourse.classes

/**
 * Practice Time

Earlier, we created and filtered a list of spices. Spices are much better represented as objects than as simple strings. Because they are objects, we can perform different things with them - such as cooking.

To recap, let's make a simple Spice class. It doesn't do much, but it will serve as the starting point for the next practice.

Create class, SimpleSpice.
Let the class be a property with a String for the name of the spice, and a String for the level of spiciness.
Set the name to curry and the spiciness to mild.
Using a string for spiciness is nice for users, but not useful for calculations. Add a heat property to your class with a getter that returns a numeric value for spiciness. Use a value of 5 for mild.
Create an instance of SimpleSpice and print out its name and heat.


 */
class SimpleSpice {
    val name: String = "curry"
    val spiceLevel : String = "mild"
    val heat : Int
        get() {return 5}
}

fun main(args : Array<String>) {
    val simpleSpice = SimpleSpice()
    println(simpleSpice.name)
    println(simpleSpice.heat)
}