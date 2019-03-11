package main.kotlin.functions

/*
Practice Time

In this practice, you are going to write the the first part of a higher-order functions game. You will implement everything, except the higher-order functions. Let’s get started.

    Create a new file.
    Create an enum class, Directions, that has the directions NORTH, SOUTH, EAST and WEST, as well as START, and END.
    Create a class Game.
    Inside Game, declare a var, path, that is a mutable list of Direction. Initialize it with one element, START.
    Create 4 lambdas, north, south, east, and west, that add the respective direction to the path.
    Add another lambda, end, that:
        Adds END to path
        Prints “Game Over”
        Prints the path
        Clears the path
        Returns false
    Create a main function.
    Inside main(), create an instance of Game.
    To test your code so far, in main() print the path, then invoke north, east, south, west, and end. Finally, print the path again.

You should see this output:

> [START]
Game Over: [START, NORTH, SOUTH, EAST, WEST, END]
[]

You will finish your game as the last practice in this course
 */

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Directions.START)

    var north = { path.add(Directions.NORTH) }
    var south = { path.add(Directions.SOUTH) }
    var east = { path.add(Directions.EAST) }
    var west = { path.add(Directions.WEST) }

    var end = {
        path.add(Directions.END)
        println("Game Over : $path")
        path.clear()
        false
    }

    fun move(where : () -> Boolean) : Unit {
        where()
    }

    fun makeMove(like : String?) {
        when (like) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun main(args: Array<String>) {
    val game = Game()

    while(true) {
        println("Enter a direction: n/s/e/w")
        val userChoice = readLine()
        game.makeMove(userChoice)
    }
}

class Location(var width : Int = 4, var height : Int = 4) {
    val map = Array(width) { arrayOfNulls<String>(height)}
    val initialLocation = Pair(1, 1)

    init {
       map[0] = arrayOf("karnataka", "tamil nadu", "tamil nadu", "kerela")
       map[1] = arrayOf("asgard", "krypton", "Zune", "heimdall")
    }

    // Complete the above.
    fun updateLocation(move : Int) {

    }
}