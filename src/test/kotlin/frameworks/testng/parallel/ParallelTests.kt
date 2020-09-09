package frameworks.testng.parallel

import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@Test(groups = ["parallel"])
class ParallelTests {
    fun testOne() {
        print(Thread.currentThread().id);
    }

    fun testSecond() {
        print(Thread.currentThread().id);
    }

    fun testThree() {
        print(Thread.currentThread().id);
    }

    fun testFour() {
        print(Thread.currentThread().id);
    }

    fun testFive() {
        print(Thread.currentThread().id);
    }
}

@Test(groups = ["parallel"])
class ParallelTestWithDataProvider {

    @DataProvider()
    fun nos(): MutableIterator<Array<Any>> {
        val data = arrayListOf<Array<Any>>()

        for (num in 1..10000) {
            data.add(arrayOf(num, num + 1, (num * 2) + 1))
        }

        return data.iterator()
    }


    @Test(dataProvider = "nos")
    fun calculateSum(first: Int, second: Int, expected: Int) {
        Assert.assertEquals(first + second, expected)
    }
}