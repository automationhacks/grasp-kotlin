package courses.udacity

fun main(args: Array<String>) {
// Link to refer constructs to handle nullibility in kotlin
// https://kotlinlang.org/docs/reference/null-safety.html

/*
Practice Time: udacitycourse.Nullability/Lists
Create a list with two elements that are null; do it in two different ways.
Next, create a list where the list is null.
 */

    var elements: List<String?> = listOf(null, null)
    println("Hello i am a list with nulls: " + elements)

    var newElements: List<String>? = null
    println("Hey. I am a list who itself is : " + newElements)

/*
Practice Time: Null Checks
Create a nullable integer variable called nullTest, and set it to null. Use a null-check that increases the value by one if it's not null, otherwise returns 0, and prints the result.
Hint: Use the Elvis operator.
 */

    var nullTest: Int? = null
    var result: Int? = nullTest?.inc() ?: 0
    println("Result after using elvis operator ?: is " + result)
}