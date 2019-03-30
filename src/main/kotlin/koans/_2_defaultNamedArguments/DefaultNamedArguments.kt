package main.kotlin.koans._2_defaultNamedArguments

// CONCEPT 1:
// Function in kotlin is defined with fun keyword
// Parameters follow pascal notation i.e. name of variable followed by type
// return type can be denoted after `:` and is optional to mention if it is Unit

// Parameters can have default value which applied in case no value is provided in call.
// This avoids the need to have multiple overloads
fun add(a: Int, b: Int = 7): Int {
    return a + b
}

// CONCEPT 2:
// Default parameters in an override case
open class Foo {
    open fun foobar(i: Int = 10) {
        println(i)
    }
}


open class Bar : Foo() {
// CONCEPT 3
// Overriding func must NOT have the default parameter value specified
// Below is NOT allowed
//    override fun foobar(i: Int = 20) {
//        super.foobar(i)
//    }

    // override fun is redundant here.
    override fun foobar(i: Int) {
        super.foobar(i)
    }
}

/*
CONCEPT 4
If a default parameter precedes a non default param
To use default param value we can call the non default param (fooBaz in this case) as a named param i.e. fooBaz = <value>
 */
fun bar(baz : Int = 1, fooBaz : Int) {
    println("baz = $baz fooBaz = $fooBaz")
}

/*
CONCEPT 5:
If last argument is a lambda:
1. We can directly pass the lambda in outside parenthesis
2. We can also pass it inside as a named parameter
 */
fun useLambdaWithDefault(foo : Int = 0, bar : Int = 1, lambda : () -> Unit) {
    println("------")
    lambda()
    println("$foo $bar")
}

fun useLambda() {
    useLambdaWithDefault { println("Using defaults for foo and bar and this lambda outside parenthesis") }
    useLambdaWithDefault(1) { println("Uses another value for foo and lambda outside parenthesis") }
    useLambdaWithDefault(foo = 5, lambda = {println("Lambda as a named parameter")})
}

/*
CONCEPT 6:
When a func has both positional (foo) and named parameters (bar)
We need to provide positional args always first
If we try to pass named param first followed by positional, It will be a compile time error
 */

fun namedParameters(foo : Int, bar : String = "Hello") {
    println("$foo $bar")
}

fun main(args: Array<String>) {
    // Function call be called by mentioning arguments within round brackets
    println(add(5, 6))

    // Default value of 7 is applied
    println(add(5))

    // Member methods can be called using the dot notation as below
    Bar().foobar(6) // 6 i.e. take the overridden value
    Bar().foobar() // 10 i.e. default value from parent class

    bar(fooBaz = 3)

    useLambda()

    namedParameters(1) // Valid
//    namedParameters(bar = "Not hello", 2) Invalid
}
