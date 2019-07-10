package programming

fun main() {
    val nums = (1..100).toList()

    val fizz = arrayListOf<Int>()
    val buzz = arrayListOf<Int>()
    val fizzBuzz = arrayListOf<Int>()


    for (num in nums) {
        if (num % 3 == 0 && num % 5 == 0) {
            fizzBuzz.add(num)
            continue
        }

        if (num % 3 == 0) {
            fizz.add(num)
        } else if (num % 5 == 0) {
            buzz.add(num)
        }

    }

    println(fizz)
    println(buzz)
    println(fizzBuzz)
}