package concepts.idioms.refactored._05_expressions

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

fun apiResponsesIdiomatic(response: Response) = when (response.statusCode) {
    in setOf(200, 201, 204) -> "Success"
    300 -> "Redirection"
    400 -> "Bad request"
    401 -> "Unauthorized"
    500 -> "Server error"
    else -> "Unknown"
}

fun main() {
    val success = Response(200)
    val clientError = Response(400)

    println(apiResponsesIdiomatic(success))
    println(apiResponsesIdiomatic(clientError))
}