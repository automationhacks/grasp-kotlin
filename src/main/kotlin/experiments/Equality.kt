package experiments

data class Foo(val name: String, val address : String)

fun main(args : Array<String>) {
    val expected = arrayListOf<Foo>(Foo("Gaurav", "HSR"),
            Foo("Shami", "Indiranagar"))
    val actual = arrayListOf<Foo>(Foo("Shami", "Indiranagar"), Foo("Gaurav", "HSR")
            )

    println(actual.containsAll(expected))
}