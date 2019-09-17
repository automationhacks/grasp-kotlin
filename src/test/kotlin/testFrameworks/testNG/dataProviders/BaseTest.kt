package testFrameworks.testNG.dataProviders

import org.testng.annotations.DataProvider

open class BaseTest {

    @DataProvider(name = "personData")
    fun personData(): MutableIterator<Array<String>> {
        val personNames = mutableListOf(
            arrayOf("Rob", "Smith"),
            arrayOf("Steve", "Brackett")
        )
        return personNames.iterator()
    }
}