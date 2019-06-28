package graspSpek.coreConcepts

import org.spekframework.spek2.Spek

object HelloWorld : Spek({
    println("This is Root")
    group("some group") {
        println("Some group...")
        test("some test") {
            println("Some test")
        }

        group("some nested group") {
            println("Another group")
            test("another test") {
                println("Another test")
            }
        }
    }
})