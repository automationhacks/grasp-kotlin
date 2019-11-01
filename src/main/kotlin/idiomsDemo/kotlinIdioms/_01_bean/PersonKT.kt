package idiomsDemo.kotlinIdioms._01_bean

class PersonKT(
    val name: String,
    val age: Int
)

fun main(args: Array<String>) {
    val person = PersonKT("Jack", 30)

    println(person.name)
    println(person.age)
}