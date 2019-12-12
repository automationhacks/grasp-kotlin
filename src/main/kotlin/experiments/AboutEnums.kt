package experiments

enum class Mouses(
    val brand: String
) {
    LOGITECH("logi"),
    DELL("dell")
}

enum class MousesV1(
    val brand: String
) {
    LOGITECH("logi"),
    DELL("dell");

    companion object {
        private val mapping = values().associateBy(MousesV1::brand)
        fun fromValue(value: String) = mapping[value] ?: error("Look up failed for ${this.javaClass.declaringClass}")
    }
}


fun main() {
    println(Mouses.valueOf("LOGITECH"))

    // Verbose impl
    lateinit var enum: Mouses

    for (value in Mouses.values()) {
        if (value.brand == "logi") {
            enum = value
        }
    }

    println(enum)
    println(enum.brand)

    println("=== V2 impl ===")
    // concise impl
    println(MousesV1.fromValue("logi").brand)
    println(MousesV1.fromValue("doesntexist").brand)
}