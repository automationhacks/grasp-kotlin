package main.kotlin.udacitycourse

import java.util.*

/*
Let's go through an example of getting information about a book in the format of a Pair.
Generally, you want information about both the title and the author, and perhaps also the year.

Let’s create a basic book class, with a title, author, and year. Of course, you could get each of the properties separately.
Create a method that returns both the title and the author as a Pair.
Create a method that returns the title, author and year as a Triple. Use the documentation to find out how to use Triple.
Create a book instance.
Print out the information about the book in a sentence, such as: “Here is your book X written by Y in Z.”
 */

/*
Practice Time
    Create a top-level constant for the maximum number of books a person could borrow.
    Inside the Book class, create a method canBorrow() that returns true or false depending on whether a user has already borrowed the max number of books.
    Create a Constants object that provides constants to the book.
    For this example, provide the BASE_URL for all books in the library catalog.
    Inside Book, add a method printUrl that creates and prints a URL composed of BASE_URL, the book title, and “.html”.
    The base URL is really of interest to the Book class. As such, it makes sense to limit its scope to the Book class. Use a companion object to define the constant in Book.
 */
const val MAX_BOOKS = 3

/*
It can be useful to know the weight of a book, for example, for shipping.
The weight of a book can change because sometimes pages get torn, and the page count changes.
While calculating the weight could be defined as a method, it’s more like a helper function.
Besides, it would hurt a book's feelings to have a method that tears up its pages.

    Add a mutable property pages to Book.
    Create an extension function on Book that returns the weight of a book as the page count multiplied by 1.5 grams.
    Create another extension, tornPages(), that takes the number of torn pages as an argument and changes the page count of the book.
    Write a class Puppy with a method playWithBook() that takes a book as an argument, and removes a random number of pages from the book.
    Create a puppy and give it a book to play with, until there are no more pages.

Note: If you don’t want to give your puppy a book, then create a puzzle toy class and fill it with treats.

 */
class Puppy {
    fun playWithBook(book : Book) {
        var random = Random()
        var toRemove = random.nextInt(book.pages)
        book.pages -= toRemove
    }
}


class Book(val title: String, val author: String, val year: String, val hasBooks: Int = 0, var pages : Int = 100) {
    companion object {
        const val BASE_URL = "http://www.foo.com"
    }

    fun getTitleAuthor(): Pair<String, String> {
        return title to author
    }

    fun getAllBookDetails(): Triple<String, String, String> {
        return Triple(title, author, year)
    }

    fun canBorrow(hasBooks: Int): Boolean {
        return hasBooks > MAX_BOOKS
    }

    fun printUrl() {
        println("$BASE_URL/$title.html")
    }
}

// Extension function
// Can be called outside the class and has access only to public variables
// Typically used to defined helper methods on a class
fun Book.getWeight() : Double {
    return pages * 1.5
}

// Another extension function
fun Book.getTornPages(tornPages : Int) {
    this.pages -= tornPages
}

fun main(args: Array<String>) {
    val aBook = Book("Clean code", "RC Martin", "2008")

    val bookTitleAndAuthor = aBook.getTitleAuthor()
    println("Here is your book ${bookTitleAndAuthor.first} written by ${bookTitleAndAuthor.second}")

    val (title, author, year) = aBook.getAllBookDetails()
    println("Here is your book $title written by $author in $year")

    val puppy = Puppy()
    puppy.playWithBook(aBook)
    println("No of pages left after puppy played is: ${aBook.pages}")
}