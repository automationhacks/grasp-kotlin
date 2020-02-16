package testFrameworks.testNG.setupTearDown

import org.testng.ITestContext
import org.testng.annotations.*

open class BaseTest {
    @BeforeSuite(alwaysRun = true)
    fun beforeSuite() {
        print("Before suite")
    }

    @BeforeMethod(alwaysRun = true)
    fun beforeMethodInBase(ctx: ITestContext) {
        println("Before method in base class")
        ctx.setAttribute("name", "foo")
    }

    @AfterSuite(alwaysRun = true)
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
    fun add(ctx: ITestContext) {
        ctx.setAttribute("name", "bar")
        print("A two nos")
        println(ctx.getAttribute("name"))
    }

    @Test
    fun addThree(ctx: ITestContext) {
        print("Add three nos")
        println(ctx.getAttribute("name"))
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