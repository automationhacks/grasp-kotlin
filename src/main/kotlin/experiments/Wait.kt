package experiments

class Wait {
    fun foo(bar: () -> String?) {
        while (bar() == null) {
            println("Still going on")
        }
    }

    fun foobar(): String? {
        for (i in 1..5) {
            if (i == 4) {
                return "Hello"
            } else {
                return null
            }
        }
        return ""
    }
}

fun main(args: Array<String>) {
    val wait = Wait()
//        val func = wait.foobar
//        wait.foo(::func)

}
