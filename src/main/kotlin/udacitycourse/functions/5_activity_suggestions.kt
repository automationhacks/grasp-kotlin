package udacitycourse.functions

fun main(args: Array<String>) {
    print("\nHow is the mood: ")
    val howsTheMood = readLine()!!

    whatShouldIDoToday(howsTheMood)
//    whatShouldIDoToday("sad")
//    whatShouldIDoToday("sad", weather = "rainy", temperature = 0)
//    whatShouldIDoToday("happy", temperature = 40)
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) {
    val isHappyAndSunny = mood == "happy" && weather == "sunny"
    val isSadAndCold = mood == "sad" && weather == "rainy" && temperature == 0
    val isGoodTemperature = temperature > 35

    return when {
        isHappyAndSunny -> println("go for a walk")
        isSadAndCold -> println("stay in bed")
        isGoodTemperature -> println("go swimming")
        else -> println("stay home and read")
    }
}