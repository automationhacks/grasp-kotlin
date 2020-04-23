package frameworks.testng

import org.testng.Assert
import org.testng.annotations.Test

/**
 * We can annotate @Test at the class level and the params specified get applied to all public functions
 * In the class, In this case all the functions, foo and bar would inherit the same groups.
 * However, we can also override this in a func as per our need.
 */

@Test(groups = ["baseGroup"], priority = 1)
class TestNGGroups {
    fun foo() {

    }

    @Test(priority = 2, groups = ["childGroup"])
    fun bar() {
        Assert.assertFalse(true)
    }

    fun foobar() {

    }

}

