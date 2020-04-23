package concepts.idioms.refactored._05_expressions

fun readMeByChar(text: String?): String? {
    println(text?.length)

    if (text != null) {
        text.forEach { it -> println(it) }
    }

    // Typical ways of handing null values
    if (text == null) return null
    if (text == null) throw RuntimeException("Unexpected null")
    if (text == null) error("Unexpected null")

    return ""
}

fun readMeByCharV2(text: String?): String? {
    val result = text!!.length
    println(result)

    if (text != null) {
        text.forEach(::println) // Convert to method reference
    }

    // Typical ways of handing null values
    val s = text ?: return null // give default value if text is null

    if (text == null) return null
    if (text == null) throw RuntimeException("Unexpected null")
    if (text == null) error("Unexpected null")

    return ""
}

fun main() {
    readMeByChar("Welcome to wonderful world of kotlin!")
    readMeByChar(null)

    readMeByCharV2("Welcome to wonderful world of kotlin again!")
    readMeByCharV2(null)
}