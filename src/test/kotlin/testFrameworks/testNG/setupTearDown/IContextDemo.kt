package testFrameworks.testNG.setupTearDown

import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

data class Person(val greeting: String, val name: String)

class IContextDemo {
    @DataProvider(name = "dp")
    fun dp(): MutableIterator<Array<Any>> {
        val data: ArrayList<Array<Any>> = arrayListOf()

        data.add(arrayOf(Person("Hello", "Bunty")))
        data.add(arrayOf(Person("Goodbye", "Foo")))

        return data.iterator()
    }

    @BeforeMethod
    fun setup(icontext: ITestContext, person: Array<Any>) {
        println("Before execution")
        val result = (person.first() as Person).greeting
        icontext.setAttribute("result", result)
    }

    @Test(dataProvider = "dp")
    fun theTest(icontext: ITestContext, person: Person) {
        println("${person.greeting} ${person.name}")
        println("Result --- ${icontext.getAttribute("result")}")
    }

    @AfterMethod
    fun teardown(icontext: ITestContext, person: Array<Any>) {
        println("After execution")
        println("Result --- ${icontext.getAttribute("result")}")
    }
}

