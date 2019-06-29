package graspSpek.styles

import org.junit.Assert
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class Calc {
    fun add(first: Int, second: Int): Int {
        return first + second
    }

    fun sub(first: Int, second: Int): Int {
        return first - second
    }
}

/**
 * describe = group or class (testNG) | Describes an action
 * it = test or @Test | Check the side effect of that action
 */
object Calculator : Spek({
    describe("A calculator") {
        val calculator by memoized { Calc() }
        it("returns sum of its arguments") {
            Assert.assertEquals(3, calculator.add(1, 2))
        }
    }

    describe("Substraction") {
        var result = 0

        beforeEachTest {
            result = 5 - 2
        }

        it("returns sub of two numbers") {
            Assert.assertEquals(2, result)
        }
    }
})