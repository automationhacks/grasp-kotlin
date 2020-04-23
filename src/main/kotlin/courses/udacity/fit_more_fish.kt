package courses.udacity

// Refer to Fit more fish problem in /resources/problems.md
// This problem highlights use of default parameters in kotlin

fun fitMoreFish(tankSize: Double,
                currentFish: List<Int>,
                fishSize: Int = 2,
                hasDecorations: Boolean = true): Boolean {

    var availableSpace = tankSize

    if (hasDecorations) {
        availableSpace -= (0.2 * tankSize)
    }

    var total = 0

    for (currentSize in currentFish)
        total += currentSize

    availableSpace -= total
    return availableSpace - fishSize > 0

}


fun main(args: Array<String>) {
    println(fitMoreFish(10.0, listOf(3, 3, 3)))
    println(fitMoreFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1, 1, 3), 3))
    println(fitMoreFish(10.0, listOf(), 7, true))
}
