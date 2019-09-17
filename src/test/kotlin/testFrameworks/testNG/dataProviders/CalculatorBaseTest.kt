package testFrameworks.testNG.dataProviders

import org.testng.annotations.DataProvider

open class CalculatorBaseTest {
    @DataProvider(name = "calculatorData")
    fun calculatorData(): MutableIterator<Array<Int>> {
        val testData: ArrayList<Array<Int>> = arrayListOf()

        val case1 = arrayOf(2, 5)
        val case2 = arrayOf(3, 5)

        testData.add(case1)
        testData.add(case2)

        return testData.iterator()
    }
}