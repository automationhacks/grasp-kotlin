package demo._07_expressions

fun readMeByChar(text: String?): String? {
    println(text!!.length)

    if (text != null) {
        text.forEach { it -> println(it) }
    }

    if (text == null) return null
    if (text == null) throw RuntimeException("Unexpected null")
    if (text == null) error("Unexpected null")

    return ""
}

fun main() {
    readMeByChar("Welcome to wonderful world of kotlin!")
    readMeByChar(null)
}