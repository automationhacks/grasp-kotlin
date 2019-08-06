package demo._01_bean

private var prop: String = "..."

fun getProp() = prop
fun setProp(v: String) {
    println("New value $v")
    prop = v
}