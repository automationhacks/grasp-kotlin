package demo._07_expressions

fun apiResponses(response: Response): String {
    when (response.statusCode) {
        200 -> return "Success"
        201 -> return "Success"
        204 -> return "Success"
        300 -> return "Redirection"
        400 -> return "Bad request"
        401 -> return "Unauthorized"
        500 -> return "Server error"
        else -> return "Unknown"
    }
}

fun main() {
    val success = Response(200)
    val clientError = Response(400)

    println(apiResponses(success))
    println(apiResponses(clientError))
}