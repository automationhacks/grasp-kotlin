package testFrameworks.testNG.dataProviders

import org.testng.annotations.DataProvider

class DataProviders {
    companion object {
        @DataProvider(name = "numbers")
        @JvmStatic
        fun numbers(): MutableIterator<Array<Int>> {
            val numbers: ArrayList<Array<Int>> = arrayListOf()
            val case1 = arrayOf(2, 5, 7)
            val case2 = arrayOf(3, 5, 8)

            numbers.add(case1)
            numbers.add(case2)

            return numbers.iterator()
        }
    }
}
