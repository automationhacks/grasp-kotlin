package testFrameworks.testNG.logging

import org.testng.*
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * Single file to show how reporting and logging works in TestNG
 *
 * ITestListener : live hook on every test
 * IReporter : after all tests are run
 *
 * Reference links:
 *
 * Good patterns around use of Listener
 * https://dzone.com/articles/custom-framework-listeners-1
 *
 * Gradle TestNG runs
 * https://docs.gradle.org/current/userguide/java_testing.html#test_execution_order
 */

object Logger {
    fun log(msg: String, stdOut: Boolean = true) {
        Reporter.log(msg, stdOut)
    }
}

class Listener : TestListenerAdapter() {
    override fun onStart(context: ITestContext) {
        Logger.log("Beginning test suite: ${context.outputDirectory}")
    }

    override fun onFinish(context: ITestContext?) {}
    override fun onTestSkipped(result: ITestResult?) {}

    override fun onTestStart(result: ITestResult) {
        super.onTestStart(result)
        Logger.log("===>>> Test started: ${result.name}")
    }

    override fun onTestSuccess(result: ITestResult?) {
        super.onTestSuccess(result)
        if (result != null) {
            Logger.log("<<<=== Test completed successfully: ${result.name}")
        }
    }

    override fun onTestFailure(result: ITestResult) {
        super.onTestFailure(result)
        Logger.log("<<<=== Test failed: ${result.name}")
    }

    override fun onTestFailedButWithinSuccessPercentage(result: ITestResult?) {}
}

// Dummy set  of classes representing an employee where Credited Salary
// gives out the amount to credit based on the employees level
class Level(val employeesLevel: Int)

class Salary(val money: Int)

class Employee(val name: String, val level: Level)

class CreditedSalary(private val level: Level, private val baseSalary: Salary) {
    fun getSalaryToCredit(): Int {
        return level.employeesLevel * baseSalary.money * 22
    }
}

@Test(groups = ["logging_tests"])
class LoggingTests {
    private val baseSalary = Salary(1000)
    private lateinit var employee: Employee

    @BeforeMethod
    fun given_EmployeeExists() {
        employee = Employee("Rob", Level(2))
    }

    // Example test that passes
    fun when_CreditedSalary_ShouldBeGreater_ThanBase() {
        Logger.log("Checking that credited salary is ok")
        val credit = CreditedSalary(employee.level, baseSalary)
        Assert.assertTrue(credit.getSalaryToCredit() > baseSalary.money)
    }

    // Example test that fails
    fun when_salaryIsNotCredited() {
        Logger.log("Checking that salary is not credited")
        Assert.assertTrue(false)
    }
}