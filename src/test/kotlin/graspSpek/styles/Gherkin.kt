package graspSpek.styles

import org.junit.Assert
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object Gherkin : Spek({
    Feature("Test calculator") {

        Scenario("Add two nos") {
            val first by memoized { 2 }
            val second by memoized { 3 }
            var result = 0


            When("Add two nos") {
                result = Calc().add(first, second)
            }

            Then("Results should be addition of the two") {
                Assert.assertEquals(5, result)
            }
        }
    }
})