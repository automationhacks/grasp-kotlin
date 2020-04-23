package libs.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.intellij.lang.annotations.Language
import org.testng.Assert

@Language("JSON")
val SUCCESS = """
    {
    "id": 1,
    "first_name": "John",
    "salary": 2000
    }
""".trimIndent()

val FAILURE = """
    {
    "id": 0,
    "first_name": null,
    "error": "Could not find employee"
    }
    
""".trimIndent()

sealed class Employee {
    abstract val id: Int?
    abstract val first_name: String?
}

data class EmployeeFound(
    val salary: Int, override val id: Int, override val first_name: String
) : Employee()

data class EmployeeNotFound(override val id: Int, override val first_name: String?, val error: String) : Employee()


fun main() {
    val adapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val parser = adapter.adapter(EmployeeFound::class.java)
    val success = parser.fromJson(SUCCESS)!!

    println(success.first_name)
    println(success.salary)

    checkCommonAssertions(success)

    val errorParser = adapter.adapter(EmployeeNotFound::class.java)
    val error = errorParser.fromJson(FAILURE)!!

    println(error.error)
    println(error.first_name)

    checkCommonAssertions(error)
}

fun checkCommonAssertions(employee: Employee) {
    println("Value == " + employee.id)
    Assert.assertTrue(employee.id is Int)
}