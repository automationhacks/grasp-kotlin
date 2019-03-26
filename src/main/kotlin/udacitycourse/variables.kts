package main.kotlin.udacitycourse

var a = 5
println(5)

var b = 6 // Can change
println(a + b)

val c = 7 // Does not change
// error: val cannot be reassigned
//c = 8

val d = 7 + 5 - 2
println(d)

val e = d * 5 / 2
println(e)

var someByte: Byte = 1
// Implicit conversion does not happen for number types like Byte -> Int, Int -> Long
// error: type mismatch: inferred type is Byte.Companion but Int was expected
//var someInt : Int = Byte

// In such cases we have to explicitly convert the output
var anotherInt: Int = someByte.toInt()
println("Look: I got converted to Int " + anotherInt)

// Kotlin handles nullability by making sure data structures cannot be null by default
// However you can specify if a type can be null by using ? after the type

// By default a var cannot be null
// error: null can not be a value of a non-null type String
//var fish : String = null

// ? operator denotes if something can be null
var fishes: List<String?>? = listOf(null, null)
println(fishes)

/*
Practice questions:
If you start with 2 fish, and they breed twice, producing 71 offspring the first time, and 233 offspring the second time, and then 13 fish are swallowed by a hungry moray eel, how many fish do you have left? How many aquariums do you need if you can put 30 fish per aquarium?

Hint: You can chain method calls.
Hint: You can call the methods on numbers, and Kotlin will convert them to objects for you.
Bonus question: What is special about all the numbers of fish?
 */

var fishCount = 2
fishCount = fishCount.plus(71).plus(233).minus(13)
println("Total no of fishes: " + fishCount)

val noOfAquariums = fishCount.div(30)
println("Total no of aquariums used for " + noOfAquariums)

/*
Practice Time: main.kotlin.udacitycourse.Variables
Create a String variable rainbowColor, set its color value, then change it.
Create a variable blackColor whose value cannot be changed once assigned. Try changing it anyway.
 */

var rainbowColor = "indigo"
rainbowColor = "yellow"
val blackColor = "black"
//blackColor = "green" // Error
println("Color of the rainbow: " + rainbowColor)
println("What color is black? " + blackColor)

//rainbowColor = null // error: null can not be a value of a non-null type String
var greenColor: String? = null
//var blueColor: String = null

