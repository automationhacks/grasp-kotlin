package _03_functions


fun String.getFirstWord(separator: String = " "): String {
    return this.split(separator)[0]
}

// Example of extension properties
// In this case on top of a String class
val String.lastWord: String
    get() {
        return this.split("")[1]
    }

fun main() {
    val first = "Jane Doe".getFirstWord()
    val last = "John Doe".lastWord

    println("First word: $first")
    println("Last word (Using extension properties) $last")
}

