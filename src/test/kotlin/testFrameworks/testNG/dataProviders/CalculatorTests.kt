package testFrameworks.testNG.dataProviders

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class CalculatorTests : CalculatorBaseTest() {
    @Test
    fun testSum() {
        val calculator = Calculator(5, 6)
        val result = calculator.add()
        assertEquals(result, 11)
    }

    @Test(dataProvider = "calculatorData", groups = ["calculator"])
    fun testSumWithData(first: Int, second: Int) {
        val calculator = Calculator(first, second)
        val result = calculator.add()
        assertEquals(result, first.plus(second))
    }

    @Test(dataProvider = "calculatorData")
    fun testSubWithData(first: Int, second: Int) {
        val calculator = Calculator(first, second)
        val result = calculator.sub()
        assertEquals(result, first - second)
    }

    @Test(dataProvider = "numbers", dataProviderClass = DataProviders::class)
    fun testSumWithDataProvidersInDifferentFile(first: Int, second: Int, expected: Int) {
        val calculator = Calculator(first, second)
        val result = calculator.add()
        assertEquals(result, expected)
    }
}