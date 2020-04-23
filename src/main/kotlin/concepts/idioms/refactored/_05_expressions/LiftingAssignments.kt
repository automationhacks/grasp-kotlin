package concepts.idioms.refactored._05_expressions

// Simple HTTP response class
class Response(val statusCode: Int)

fun main() {
    // A sample response
    val response = Response(200)

    // Conditional statement which decides and gives a value out for further consumption
    val result: String
    if (response.statusCode == 200) {
        result = "Success"
    } else {
        result = "Failure"
    }

    println("API call results is : $result")

    // In Kotlin, After lifting the assignment out of if else block
    val anotherResult =
            if (response.statusCode == 200) {
                "Success"
            } else {
                "Failure"
            }

    println("API call results is : $result")
}