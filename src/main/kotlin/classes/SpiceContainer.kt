package main.kotlin.classes

import main.kotlin.spices.Curry

/*
    Create a simple data class, SpiceContainer, that holds one spice.
    Give SpiceContainer a property, label, that is derived from the name of the spice.
    Create some containers with spices and print out their labels.
 */

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}

fun main(args: Array<String>) {
    // Data class implements toString() and allows us to print the properties and their values instead of
    // objects memory address

    val spiceCabinet = listOf(
            SpiceContainer(Spice("Yellow curry", "mild")),
            SpiceContainer(Spice("Red curry", "hot")),
            SpiceContainer(Spice("Green curry", "luke"))
    )

    println("Here are the spices... ")
    for (spices in spiceCabinet) {
        println(spices.label)
    }
}