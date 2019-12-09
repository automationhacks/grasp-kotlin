package testFrameworks.testNG.dataProviders

import org.testng.Assert
import org.testng.ITestContext
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.lang.reflect.Method

/**
 * Example  of using m (java.lang.reflect param in data provider to get context about the test method)
 * https://testng.org/doc/documentation-main.html#parameters-dataproviders
 *
 * Stack Overflow thread: https://stackoverflow.com/questions/666477/possible-to-pass-parameters-to-testng-dataprovider
 */
class ADataProvider {
    companion object {

        @DataProvider(name = "aDataProvider")
        @JvmStatic
        fun aDataProvider(ctx: ITestContext, m: Method): MutableIterator<Any> {
            println("Inside data provider")
            println(m.defaultValue)
            println(m.name)

            println(ctx.allTestMethods)
            val rows = ArrayList<Array<Any>>()

            if (m.name == "fooTest") {
                rows.add(arrayOf("Hello", "fooTest"))
            } else {
                rows.add(arrayOf("Hello", "barTest"))
            }

            return rows.iterator()
        }
    }

}

class DataProviderWithMethodFromTest {

    @Test(dataProviderClass = ADataProvider::class, dataProvider = "aDataProvider")
    fun fooTest(greeting: String, funcName: String) {
        Assert.assertEquals(funcName, "fooTest")
    }

    @Test(dataProviderClass = ADataProvider::class, dataProvider = "aDataProvider")
    fun barTest(greeting: String, funcName: String) {
        Assert.assertEquals(funcName, "fooTest")
    }

}