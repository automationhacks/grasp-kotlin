package testFrameworks.testNG

import org.testng.Assert
import org.testng.annotations.Test

class Parallel {
    @Test(groups = ["smoke"], alwaysRun = true)
    fun foo() {
        Thread.sleep(5000)
        println("Executing foo...")
        Assert.assertTrue("1".isNotEmpty())
    }

    @Test(groups = ["smoke"], alwaysRun = true)
    fun bar() {
        Thread.sleep(3000)
        println("Executing bar...")
        Assert.assertTrue("1".isNotEmpty())
    }

    @Test(groups = ["smoke"], alwaysRun = true)
    fun foobar() {
        Thread.sleep(2000)
        println("Executing foobar...")
        Assert.assertEquals(2, 2)
    }
}
