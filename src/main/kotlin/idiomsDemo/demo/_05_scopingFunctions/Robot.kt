package idiomsDemo.demo._05_scopingFunctions

class Robot(val name: String, val function: String, val weight: Int)

fun main() {
    var chappie = Robot("Chappie", "Fight", 25)

    val name = chappie.name
    val function = chappie.function
    val weight = chappie.weight

    println("Robot is $name who does $function with weight $weight")
}