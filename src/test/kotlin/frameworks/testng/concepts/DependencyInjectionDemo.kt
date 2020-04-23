package frameworks.testng.concepts

import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.lang.reflect.Method

class DependencyInjectionDemo {
    @DataProvider
    fun numbers(m: Method, ctx: ITestContext?): Array<Array<Any>> {
        print(">>> ${m.name}")
        print(">>> ${m.parameters.forEach { it.name }}")

        return arrayOf(arrayOf<Any>(1, 2, 3), arrayOf<Any>(3, 4, 8))
    }

    @BeforeMethod
    fun setup(args: Array<Any?>?, ctx: ITestContext?) {
        println(">>> Before add")
    }

    @Test(dataProvider = "numbers")
    fun addNumbers(first: Int, second: Int, expected: Int) {
        assert(first + second == expected)
    }

    @AfterMethod
    fun teardown(args: Array<Any?>?, result: ITestResult?) {
        println(">>> After add")
    }
}