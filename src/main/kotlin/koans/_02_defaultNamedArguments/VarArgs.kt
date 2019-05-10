package koans._02_defaultNamedArguments

/**
 * In kotlin, we can pass variable no of arguments by using "spread" operator (*) and then mention
 * vararg in front of the variable in func or class declaration
 *
 * There can be only a single vararg in a list of parameters
 * Value to this can be passed either asList() or using spread operator
 * If the var arg is not the last parameter in then it can be called as a named parameter
 */

class VarArgsExample {
    fun foo(vararg strings: String) {
        print("Inside foo. Value of strings is: ${strings.map{println(it); it}}")
    }


}

fun main(args: Array<String>) {
    val example = VarArgsExample()
    example.foo(strings = *arrayOf("a, b, c"))
}
