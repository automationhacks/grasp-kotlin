package concepts.idioms.refactored._06_lambdas

fun printHex() {
    val nums = (1..100).toList()
    val list = mutableListOf<String>()

    for (it in nums) {
        if (it % 16 == 0) {
            list.add("0x" + it.toString(16))
        }
    }

    println(list)
}

fun printHexWithMapFilter() {
    val nums = (1..100).toList()
    val list = nums
            .filter { it -> it % 16 == 0 }
            .map { it -> "0x" + it.toString(16) }

    println(list)
}

fun main() {
    printHex()
}