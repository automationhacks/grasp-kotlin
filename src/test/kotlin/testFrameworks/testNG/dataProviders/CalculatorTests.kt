package testFrameworks.testNG.dataProviders

import org.testng.Assert.assertEquals
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class CalculatorTests {
    @Test
    fun testSum() {
        val calculator = Calculator(5, 6)
        val result = calculator.add()
        assertEquals(result, 11)
    }

    @Test(dataProvider = "calculatorData", groups = ["calculator"])
    fun testSumWithData(first: Int, second: Int, expected: Int) {
        val calculator = Calculator(first, second)
        val result = calculator.add()
        assertEquals(result, expected)
    }

    @DataProvider(name = "calculatorData")
    fun calculatorData(): MutableIterator<Array<Int>> {
        val testData: ArrayList<Array<Int>> = arrayListOf()

        val case1 = arrayOf(2, 5, 7)
        val case2 = arrayOf(3, 5, 8)

        testData.add(case1)
        testData.add(case2)

        return testData.iterator()
    }
}