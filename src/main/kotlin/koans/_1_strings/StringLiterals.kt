package main.kotlin.koans._1_strings

/*
https://kotlinlang.org/docs/reference/basic-types.html#string-literals
 */
fun main(args : Array<String>) {
    // Escaped String: Similar to Java string where each special character can be escaped with a backslash
    val escapedString = "Hello, World!\n"
    println(escapedString)

    // RawString: Does not need escaping and created via triple quotes
    val rawString = """
       Tell me and I forget.
       Teach me and I remember.
       Involve me and I learn
    """.trimIndent()
    println(rawString)

    val name  = "Robert"
    // String templating: Dollar followed by variable value and
    // To execute an expression use ${expression within curly braces}
    println("$name is really smart and his name is ${name.length} chars long")
}