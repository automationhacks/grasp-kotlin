package idiomsDemo.demo._06_dataStructures

fun main() {
    val aMap = HashMap<String, Int>()

    aMap.put("Flash", 28)
    aMap.put("Wonder women", 100)
    aMap.put("Batman", 40)

    for (e in aMap.entries) {
        val key = e.key
        val value = e.value
        println("key $key -> $value")
    }
}