package testFrameworks.testNG.setupTearDown

import org.testng.annotations.*

open class BaseTest {
    @BeforeSuite
    fun beforeSuite() {
        print("Before suite")
    }

    @AfterSuite
    fun afterSuite() {
        print("After suite")

    }
}

class CalculatorTest : BaseTest() {
    @BeforeClass
    fun beforeClass() {
        print("Before class")
    }

    @BeforeMethod
    fun beforeMethod() {
        print("Before method")
    }

    @Test
    fun add() {
        print("A two nos")
    }

    @Test
    fun addThree() {
        print("Add three nos")
    }

    @AfterMethod
    fun afterMethod() {
        print("After method")
    }

    @AfterClass
    fun afterClass() {
        print("After class")
    }
}