package courses.udacity.functions

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

    fun move(where: () -> Boolean) {
        where.invoke()
    }

    fun makeMove(command: String?) {
        when (command) {
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

    while (true) {
        println("Enter a direction: n/s/e/w")
        val userChoice = readLine()
        game.makeMove(userChoice)
    }
}

class Location(var width: Int = 4, var height: Int = 4) {
    val map = Array(width) { arrayOfNulls<String>(height) }
    var initialLocation = Pair(0, 0)

    init {
        map[0] = arrayOf("karnataka", "tamil nadu", "tamil nadu", "kerela")
        map[1] = arrayOf("asgard", "krypton", "Zune", "heimdall")
        map[2] = arrayOf("vienna", "paris", "london", "zurich")
        map[3] = arrayOf("lucknow", "meerut", "prayagraj", "saharanpur")
    }

    // Complete the above.
//    fun updateLocation(move: Char): Pair {
//        when (move) {
//            'n' -> return Pair(initialLocation.first , (initialLocation.second + 1).rem(height))
//            's' -> return Pair(initialLocation.first , (initialLocation.second - 1).rem(height))
//            'e' -> return Pair(initialLocation.first , (initialLocation.second + 1).rem(width))
//            'w' ->
//            else ->
//        }

//    }
    /*
    Practice Time

In this practice, you will finish your simple game using higher-order functions, that is, a function that takes functions as an argument.

    In the game class, create a function move() that takes an argument called where, which is a lambda with no arguments that returns Unit.

    Hint: Declaring a function that takes a lambda as its argument:

    fun move(where: () -> Boolean )

    Inside move(), invoke the passed-in lambda.
    In the Game class, create a function makeMove() that takes a nullable String argument and returns nothing.

    Inside makeMove, test whether the String is any of the 4 directions and invoke move() with the corresponding lambda. Otherwise, invoke move() with end.

    Hint: You can call the function like this:

    move(north)

    In main() add a while loop that is always true.
    Inside the loop, print instructions to the player:

    print("Enter a direction: n/s/e/w:")

    Call makeMove() with the contents of the input from the user via readLine()
    Remove the code for testing the first version of your game.
    Run your program.

Challenge:

Create a simple “map” for your game, and when the user moves, show a description of their location. Consider the following:

    Use a Location class that takes a default width and height to track location. 4x4 is pretty manageable.
    You can create a matrix like this:

    val map = Array(width) { arrayOfNulls<String>(height) }

    Use an init block to initialize your map with descriptions for each location.
    When you move() also updateLocation(). There is some math involved to prevent null-pointer exceptions and keep the user from walking off the map. rem() and absoluteValue come handy.
    When you are done, zip up the code and send it to a friend to try your first Kotlin game.
     */
}
