package _03_functions


fun getFirstWord(word: String, separator: String = " "): String {
    return word.split(separator)[0]
}

fun main() {
    val first = getFirstWord("Jane,Doe", separator = ",")
    println("First word: $first")
}

