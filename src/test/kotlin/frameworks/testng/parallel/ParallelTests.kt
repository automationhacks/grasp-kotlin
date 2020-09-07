package frameworks.testng.parallel

import org.testng.annotations.Test

class ParallelTests {
    @Test(groups = ["hello"])
    fun testOne() {
        print(Thread.currentThread().id);
    }

    @Test
    fun testSecond() {
        print(Thread.currentThread().id);
    }

    @Test
    fun testThree() {
        print(Thread.currentThread().id);
    }

    @Test
    fun testFour() {
        print(Thread.currentThread().id);
    }

    @Test
    fun testFive() {
        print(Thread.currentThread().id);
    }
}