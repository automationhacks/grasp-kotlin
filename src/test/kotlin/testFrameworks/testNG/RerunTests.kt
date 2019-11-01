package testFrameworks.testNG

import framework.core.retry.FailureRunner
import org.testng.Assert
import org.testng.annotations.Test

// https://testng.org/doc/documentation-main.html#rerunning
@Test(groups = ["rerun"], retryAnalyzer = FailureRunner::class)
class RerunTests {
    fun foobar() {
        Assert.assertFalse(true)
    }

    fun foo() {
        Assert.assertEquals(2, 2)
    }
}