package concepts.objectsReferences

open class Person {
    var name: String = ""
}

class Student(val id: Int) : Person()
class Faculty(val id: String) : Person()

fun main() {
    val student = Student(1)
    student.name = "Gaurav"
    // ok
    // Child class has all the public properties and methods of its parent
    println(student.name)

    // ok
    // A parent class can always store a reference of the child class
    // A Student is always a Person
    val aPerson: Person
    aPerson = student
    println("Person points to student: ${aPerson.id}")

    val anotherPerson: Person
    var faculty = Faculty("1")
    // Type mismatch - not ok
    // child class cannot store reference to parent class
    // faculty = anotherPerson
    // if we forcibly cast parent to child then we would get a ClassCastException at runtime
    // i.e faculty = anotherPerson as Faculty

    // ok
    // obj : Any class is the parent class of all objects and can
    // store reference to any class
    var obj: Any = Faculty("2")
    obj = student
}
