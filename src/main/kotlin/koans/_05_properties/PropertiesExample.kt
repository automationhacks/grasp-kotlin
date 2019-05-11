package koans._05_properties

class Address {
    // properties can be declared as either var (mutable) or val (immutable)
    var name : String = ""
    var location : String = ""

    var firstName : String = ""
    var lastName : String = ""

    // Property can have a custom getter declared. For instance for a computed property as below:
    val fullName : String
        get() = "$firstName $lastName"
}

class LocalAddress {
    // Property Type is optional if it can be inferred by the compiler
    var index = 1

    // Has type String, since it is read only (due to val) this property only allows a getter.
    val country : String? = null
}

fun copyAddress(address : Address) : Address {
    val copiedAddress = Address()

    // To refer property  we simple refer to it by name
    copiedAddress.firstName = address.firstName
    copiedAddress.lastName = address.lastName

    println("Full name: ${address.fullName}")

    return copiedAddress
}

fun main(args : Array<String>) {
    val address = Address()
    address.firstName = "Hello"
    address.lastName = "World!"

    copyAddress(address)
}