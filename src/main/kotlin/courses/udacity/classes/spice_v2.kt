package courses.udacity.classes

/**
Practice Time

Let's improve our SimpleSpice class so that we can have various spices with different levels of spiciness.

Create a new class, Spice.
Pass in a mandatory String argument for the name, and a String argument for the level of spiciness where the default value is mild for not spicy.
Add a variable, heat, to your class, with a getter that returns a numeric value for each type of spiciness.
Instead of the list of spices as Strings you used earlier, create a list of Spice objects and give each object a name and a spiciness level.
Add an init block that prints out the values for the object after it has been created. Create a spice.
Create a list of spices that are spicy or less than spicy. Hint: Use a filter and the heat property.
Because salt is a very common spice, create a helper function called makeSalt().
 */

class Spice(val name: String, val spiceness: String = "mild") {
    val heat: Int
        get() {
            return when (spiceness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init {
        println("Hello you created a spice with name: $name and it's $spiceness")
    }
}

fun makeSalt() = Spice("salt", "low")

fun main(args: Array<String>) {
    val garamMasala = Spice("garam masala", "very spicy")
    val sambharMasala = Spice("sambhar masala", "mild")
    val spices = listOf(garamMasala, sambharMasala, makeSalt())

    println(spices.filter { it.heat < 6 })
}