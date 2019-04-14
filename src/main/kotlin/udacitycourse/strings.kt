package main.kotlin.udacitycourse

fun main(args: Array<String>) {
    /*
   Practice Time
       Create three String variables for trout, haddock, and snapper.
       Use a String template to print whether you do or don't like to eat these kinds of fish.
    */

    var trout: String = "trout fish"
    var haddock: String = "haddock fish"
    var snapper: String = "snapper fish"
    println("Hey i do not like to eat $trout or $haddock but do like $snapper")

/*
Practice Time

when statements in Kotlin are like case or switch statements in other languages.

Create a when statement with three comparisons:

    If the length of the fishName is 0, print an error message.
    If the length is in the range of 3...12, print "Good fish name".
    If it's anything else, print "OK fish name".
 */

    var fishName: String = "Nemo"
    when (fishName.length) {
        0 -> println("Error: Length of fish name is 0")
        in 3..12 -> println("Good fish name")
        else -> println("OK fish name")
    }
}

