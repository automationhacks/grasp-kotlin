package main.kotlin.udacitycourse.collections

/*
One book is rarely alone, and one author rarely writes just one book.

    Create a Set of book titles called allBooks, for example, by William Shakespeare.
    Create a Map called library that associates the set of books, allBooks, to the author.
    Use the collections function any() on library to see if any of the books are “Hamlet’
    Create a MutableMap called moreBooks, and add one title/author to it.

    Use getOrPut() to see whether a title is in the map, and if the title is not in the map, add it.

    Hints:
        any() is applied to a collection and takes a lambda as its argument, for example:

        myList.any {it.contains(“name”)}

        getOrPut() is a handy function that will check whether a key is in a map, and if it is, will return the value. Otherwise, it will add the key with the supplied value to the map.
        mapOf() may come in handy.
 */


fun main(args : Array<String>) {
    val allBooks = setOf("Merchant of venice", "The story of king lear", "Gilgamesh", "Hamlet")
    println(allBooks)

    val library = mapOf("William shakespeare" to allBooks)
    println(library)
    println(library.any {it.value.contains("Hamlet")})

    val moreBooks = mutableMapOf("Eric reis" to "Lean startup")
    moreBooks.getOrPut("RC Martin",   {"Clean coder"})
    println(moreBooks)
}