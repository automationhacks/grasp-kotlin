package demo._08_functional

fun printEven() {
    val nums = (1..100).toList()
    val list = mutableListOf<Int>()

    for (it in nums) {
        if (it % 2 == 0) {
            list.add(it)
        }
    }

    println(list)
}

fun main() {
    printEven()
}