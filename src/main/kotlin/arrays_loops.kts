import kotlin.math.pow

/*
1 byte = 1 bytes
1 kilobyte = 1000 bytes
1 megabyte = 1000000 bytes
1 gigabyte = 1000000000 bytes
1 terabyte = 1000000000000 bytes
1 petabyte = 1000000000000000 bytes
1 exabyte = 1000000000000000000 bytes
 */

// Note pow uses 1000.0 which is a double value instead of 1000
// it = iterable, which gives access to current iterable
val array = Array(7) { 1000.0.pow(it) }

val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte", "terabyte", "petabyte", "exabyte")

for ((index, value) in array.withIndex()) {
    println("1 ${sizes[index]} = ${value.toLong()} bytes")
}

/*
 * Practice Time

Looping over arrays and lists is a fundamental technique that has a lot of flexibility in Kotlin. Let's practice.
Basic example

Create an integer array of numbers called numbers, from 11 to 15.
Create an empty mutable list for Strings.
Write a for loop that loops over the array and adds the string representation of each number to the list.
 */

var numbers: IntArray = intArrayOf(11, 12, 13, 14, 15)
var strList: MutableList<String> = mutableListOf<String>()

println("Now adding nos to strList")
for (number in numbers) {
    strList.add(numbers.toString())
}

/*
How can you use a for loop to create (a list of) the numbers between 1 and 100 that are divisible by 7?
 */
var aList: MutableList<Int> = mutableListOf()

for (num in (0..100 step 7)) {
    aList.add(num)
}

print(aList)