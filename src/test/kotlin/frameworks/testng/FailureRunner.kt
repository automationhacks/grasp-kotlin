package frameworks.testng

import org.testng.IRetryAnalyzer
import org.testng.ITestResult
import org.testng.Reporter

class FailureRunner : IRetryAnalyzer {
    private var retryCounter = 0
    private var maxRetryCount = System.getProperty("maxFailureRetries").toInt()

    override fun retry(result: ITestResult?): Boolean {
        val testName = result?.testName
        return if (retryCounter < maxRetryCount) {
            Reporter.log("Current retry count <$retryCounter> < max failure retries <$maxRetryCount>")
            Reporter.log("Retrying $testName")
            ++retryCounter
            true
        } else {
            Reporter.log("Retry count exceeded max limit for $testName.")
            false
        }
    }
}