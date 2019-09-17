package testFrameworks.testNG.dataProviders

class Calculator(
    val first: Int,
    val second: Int
) {
    fun add(): Int {
        return first + second
    }
}

