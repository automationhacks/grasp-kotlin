package demo._01_bean

class PersonKT {
    private var name: String
    private var age: Int

    constructor(n: String, a: Int) {
        name = n
        age = a
    }

    fun getName(): String {
        return name
    }

    fun setName(n: String) {
        name = n
    }

    fun getAge(): Int {
        return age
    }
}