package experiments

import org.joda.time.DateTime
import org.testng.annotations.Test


object Wait {

    fun until(function: () -> Boolean, timeout: Int = 30, retryAfter: Int = 2): Boolean {
        val endAt = DateTime.now().plus(timeout.toLong() * 1000)
        var current = DateTime.now()

        while (current < endAt) {
            val result = function()
            if (result) {
                println("Evaluated to true. Exiting wait polling loop")
                return result
            }

            println("Evaluated to false.. Waiting for $retryAfter secs ")
            Thread.sleep(retryAfter.toLong() * 1000)
            current = DateTime.now()
        }
        println("Wait function hit timeout limit of $timeout secs")
        return function()
    }
}

class WaitTests {
    @Test
    fun testFunctionWaitsUntilTimeout() {
        val counter = 0
        Wait.until({ counter == 1 })
    }

    @Test
    fun testFunctionReturnsTrueBeforeTimeout() {
        var counter = 0
        val incrementCounterTillLimit = {
            if (counter > 2) {
                true
            } else {
                ++counter
                false
            }
        }

        Wait.until(incrementCounterTillLimit)
    }
}


