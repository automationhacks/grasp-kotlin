package _04_traversingHierarchies

sealed class Element
class Container(vararg val children: Element) : Element()
class Text(val text: String) : Element()

fun main() {
    val root = Container(
            Text("a"),
            Container(
                    Text("b"),
                    Container(
                            Text("c"),
                            Text("d")
                    )
            ),
            Text("e")
    )

    println(root.extractText())
}

fun Element.extractText(): String {
    val sb = StringBuilder()

    fun extractText(e: Element) {
        when (e) {
            is Text -> sb.append(e.text)
            is Container -> {
                e.children.forEach(::extractText)
            }
        }
    }

    extractText(this)
    return sb.toString()
}
