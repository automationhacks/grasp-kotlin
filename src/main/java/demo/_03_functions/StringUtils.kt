package demo._03_functions

class StringUtils {
    fun getFirstWord(word: String, separator: String): String {
        return word.split(separator)[0]
    }

    fun getFirstWord(word: String) = getFirstWord(word, " ")
}

fun main(args: Array<String>) {
    val first = StringUtils().getFirstWord("Jane Doe")
    println("First word: $first")
}