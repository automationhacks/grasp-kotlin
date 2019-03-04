package main.kotlin

import java.lang.Math.random
import java.util.*

fun main(args: Array<String>) {
    // What is the difference between the below statements
    val random1 = random()
    val random2 = { random() }
    /**
     * random1 has a value assigned at compile time, and the value never changes when the variable is accessed.

    random2 has a lambda assigned at compile time, and the lambda is executed every time the variable is referenced, returning a different value.
     */

    println(random1)
    println(random2)


    /**
    Practice Time: Lambdas

    Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
    Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
    If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
    Create a new variable, rollDice2, for this same lambda using the function type notation.

     */

    val rollDice = {
        sides : Int -> if (sides !=0) Random().nextInt(sides) + 1 else 0
    }

    // function notation
    val rollDice2 : (Int) -> Int = {
        sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1
    }

    print(rollDice(5))
    print(rollDice2(8))

    /**
     * Practice Time: Extra Questions

    Why would you want to use the function type notation instead of just the lambda?
    Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
    Pass your rollDice2 function as an argument to gamePlay() to generate a dice roll every time gamePlay() is called.
     */

    // Function type notation would ensure we don't need to specify the  input and output types for the lambda

    fun gamePlay(diceRoll : Int) {
        println(diceRoll)
    }

    gamePlay(rollDice2(4))



}


