package udacitycourse.spices

/*
Let's go back to your spices. Make Spice an abstract class, and then create some subclasses that are actual spices.

    It's easiest (organizationally) if you make a new package, Spices, with a file, Spice, that has a main() function.
    Copy/paste your Spice class code into that new file.
    Make Spice abstract.
    Create a subclass, Curry. Curry can have varying levels of spiciness,
    so we don't want to use the default value, but rather pass in the spiciness value.
    Spices are processed in different ways before they can be used.
    Add an abstract method prepareSpice to Spice, and implement it in Curry.
    Curry is ground into a powder, so let's call a method grind().
    However, grinding is something that's not unique to curry, or even to spices,
    and it's always done in a grinder.
    So we can create an Interface, Grinder, that implements the grind() method.
    Do that now.
    Then add the Grinder interface to the Curry class.
 */

/*
    Create an interface, SpiceColor, that has a color property. You can use a String for the color.
    Create a singleton subclass, YellowSpiceColor, using the object keyword, because all instances of Curry and other spices can use the same YellowSpiceColor instance.
    Add a color property to Curry of type SpiceColor, and set the default value to YellowSpiceColor.
    Add SpiceColor as an interface, and let it be by color.
    Create an instance of Curry, and print its color. However, color is actually a property common to all spices, so you can move it to the parent class.
    Change your code so that the SpiceColor interface is added to the Spice class and inherited by Curry.
 */

interface SpiceColor {
    val color: Color
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}

// object keyword is used to make a class as singleton in kotlin
object YellowSpiceColor : SpiceColor {
    override val color: Color = Color.YELLOW
}

// Below are examples of abstract classes
sealed class BasicSpice {
    abstract val name: String
    val color: SpiceColor = YellowSpiceColor

    abstract fun prepareSpice()
}

class Curry(val name: String) : Grinder, SpiceColor by YellowSpiceColor {
    override fun grind() {
        println("Oh yeah. Grinded.")
    }

}

interface Grinder {
    fun grind()
}

fun main(args: Array<String>) {
    val curry = Curry("Sambhar")
    println("The curry has color of ${curry.color}")

}

