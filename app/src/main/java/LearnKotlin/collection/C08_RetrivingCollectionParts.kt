package LearnKotlin.collection

fun main() {
    //Slice, take & drop, chunked, windowed
    val listOfCities = listOf<String>(
        "AHMEDABAD",
        "BANGALORE",
        "Hydrabad",
        "New Delhi",
        "Chennai",
        "Tiruvannathpuram",
        "Panji"
    )

    //slice - select some elements
    println(listOfCities.slice(1..3))
    println(listOfCities.slice(1..3 step 2))
    val setOfCity = listOfCities.slice(setOf(2, 3, 6))
    println(setOfCity)

    //take - first n elements
    val topFiveCities = listOfCities.take(5)
    println("4. $topFiveCities")

    //drop - gives remaining (opp of take)
    val bottomCities = listOfCities.drop(5)
    println("5. $bottomCities")

    //takeWhile - take while condition is satisfied, if it fails on first element it won't check further: Change first element to lowercase to see the diff
    val highLightedCities1 = listOfCities.takeWhile { it.equals(it.uppercase()) }
    println("6. $highLightedCities1")
    val highLightedCities2 = listOfCities.dropWhile { it.equals(it.uppercase()) }
    println("7. $highLightedCities2")

    //get elements greater than `A` alphabet
    println("8. ${listOfCities.takeWhile { it[0] >= 'A' }}")
    //println("8. ${listOfCities.takeWhile { it[0] >= 'B' }}")//?

    println("9. ${listOfCities.takeLast(2)}")
    println("10. ${listOfCities.dropLast(2)}")

    println("11. ${listOfCities.takeLastWhile { it.get(0) >= 'P' }}") //if condition fails, it won't check further
    println("12. ${listOfCities.dropLastWhile { it.get(0) >'B' }}") //removes all the elements from last to first till `A`

    println("13. ${listOfCities.chunked(3)}") //trying to make groups of equal sizes
    println("14. ${listOfCities.chunked(3){list: List<String> -> list.fold(""){acc, s -> acc + s.get(0) }}}")

    println("15. ${listOfCities.windowed(3, 2, false)}") //similar to chunk but here we can control over partial grouping
}