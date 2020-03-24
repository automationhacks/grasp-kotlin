/**
 * https://proandroiddev.com/simpler-kotlin-class-hierarchies-using-class-delegation-35464106fed5
 */

package experiments

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


abstract class Parent {
    abstract val foo: String
}

data class Child(
    @Json(name = "snake_foo") override val foo: String,
    val bar: List<String>
) : Parent()

data class AnotherChild(
    @Json(name = "snake_foo") override val foo: String,
    val bar: String
) : Parent()

fun <T : Parent> someFunc(something: T) {
    println(something.foo)
}

fun main(args: Array<String>) {
    val someJson = """
    {
    "snake_foo": "initial bar",
    "bar": []
    }
""".trimIndent()

    val anotherJson = """
    {
    "snake_foo": "new bar",
    "bar": ""
    }
""".trimIndent()


    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val child = moshi.adapter(Child::class.java).fromJson(someJson)!!
    val anotherChild = moshi.adapter(AnotherChild::class.java).fromJson(anotherJson)!!

    println(child)
    println(anotherChild)

    someFunc(child)
    someFunc(anotherChild)
}



