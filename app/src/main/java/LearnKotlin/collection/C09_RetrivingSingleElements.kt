package LearnKotlin.collection

fun main() {
    val listOfCities = listOf<String>(
        "AHMEDABAD",
        "BANGALORE",
        "Hydrabad",
        "New Delhi",
        "Chennai",
        "Tiruvannathpuram",
        "Panji"
    )
    println("1. ${listOfCities[0]}")
    println("1. ${listOfCities.get(0)}")
    println("1. ${listOfCities.elementAt(0)}")
    println("2. ${listOfCities.elementAtOrNull(0)}")
    println("3. ${listOfCities.elementAtOrElse(100) { index -> "No element is present" }}")
    println("4. ${listOfCities.first()}")
    println("4.1. ${listOfCities.first() { it.startsWith("H", false) }}")
    println("5. ${listOfCities.last()}")
    println("6. ${listOfCities.find { it.equals("New Delhi") }}")
    println("7. ${listOfCities.find { it.length > 10 }}")
    println("8. ${listOfCities.random()}")
    println("9. ${listOfCities.contains("AHMEDABAD")}")
    println("10. ${listOfCities.isNotEmpty()}")
    println("10. ${listOfCities.isNullOrEmpty()}")

    val rectangles = listOf<Rectangle>(
        Rectangle(3, 4),
        Rectangle(1, 1),
        Rectangle(2, 1),
    )
    for (rectangle in rectangles) {
        println("$rectangle area is ${rectangle.area}")
    }
    println("11. ${rectangles.firstNotNullOf { it.area > 12 }}")
    println("11.1 ${rectangles.firstNotNullOf { it.area.takeIf { it >= 12 } }}") //might throw exception
    println("11.2 ${rectangles.firstNotNullOfOrNull { it.area.takeIf { it >= 50 } }}")
}

data class Rectangle(val height: Int, val width: Int) {
    val area: Int get() = height * width
}
