package concepts.idioms.refactored._05_expressions

fun main() {
    // Old Java way
    val map = HashMap<String, String>()
    map.put("Stack", "Jeff")
    map.put("Overflow", "Joel")

    // We can replace .put with indices to make it a little more nicer
    map["Another"] = "Jared"
    map["Hello"] = "World"


    // Or even create a map with use of builders such as below
    val anotherMap = mapOf(
            Pair("Stack", "Jeff"),
            Pair("Overflow", "Joel")
    )

    // Or the more idiomatic way of using to function

    val finalMap = mapOf(
            "Stack" to "Jeff",
            "Overflow" to "Joel")

    // Iterate over map the old way
    for (entry in map.entries) {
        println("${entry.key} -> ${entry.value}")
    }

    // Unpacking the result values and using it directly
    for ((key, value) in map.entries) {
        println("$key -> $value")
    }
}

