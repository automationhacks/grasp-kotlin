package _03_functions


fun String.getFirstWord(separator: String = " "): String {
    return this.split(separator)[0]
}

fun main() {
    val first = "Jane Doe".getFirstWord()
    println("First word: $first")
}

