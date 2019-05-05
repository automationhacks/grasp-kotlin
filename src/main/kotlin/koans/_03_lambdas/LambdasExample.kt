package main.kotlin.koans._03_lambdas

/*
Lambda expression and anonymous functions are called function literals since they are not declared but passed
immediately as an expression

e.g. max(strings, {a, b -> a.length < b.length})

Here max is a Higher order function as it takes a func as 2nd argument
The 2nd arg is equivalent to below named function

fun compare(a : Int, b: Int) {return a.length < b.length}
 */

fun main(args: Array<String>) {
    println(sum(2, 3))
    println(anotherSum(3, 6))

}

/*
Rules for declaring a lambda:

Lambda is surrounded by curly braces and have optional type annotations
Body of the func goes after ->
Last expression of the func is taken as the return value
 */
val sum = { x: Int, y: Int -> x + y }

/*
If we remove all type annotations we can have below way of writing a lambda as well.
 */
val anotherSum: (Int, Int) -> Int = { x, y -> x + y }


