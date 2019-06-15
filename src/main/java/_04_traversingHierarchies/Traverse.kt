package _04_traversingHierarchies

abstract class Element
class Container(vararg val children: Element) : Element()
class Text(val text: String) : Element()

fun main(args: Array<String>) {
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

    fun extractText(e: Element): StringBuilder {
        if (e is Text) {
            val text = e
            sb.append(text.text)
        } else if (e is Container) {
            val container = e
            for (child in container.children) {
                extractText(child)
            }
        } else {
            error("Unrecognized element : $e")
        }
        return sb
    }

    return extractText(this).toString()

}


