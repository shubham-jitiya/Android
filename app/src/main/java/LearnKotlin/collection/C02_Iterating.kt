package LearnKotlin.collection

fun main() {
    var cart1 = mutableListOf<String>("Apple", "Banana", "Kiwi", "Orange")

    //2. traverse using for - same for set
    for (items in cart1) {
        print("$items, ")
    }
    //2. traverse using forEach - same for set
    println()
    cart1.forEach { print("$it, ") }

    //Iterate map
    var cityHasState1 = mutableMapOf<String, String>(
        "Bengaluru" to "Karnataka",
        "Chennai" to "Tamilnadu",
        "Ahmedabad" to "Gujarat"
    )
    println()
    //1. using for loop
    for (element in cityHasState1) {
        println("${element.key} -> ${element.value}")
    }
    //2. using for loop (key, value) - can use `_` to omit parameter
    for ((key, value) in cityHasState1) {
        println("$key - $value")
    }
    //3. using forEach - key - value
    cityHasState1.forEach { key, value -> println("$key, $value") }
    //4. using forEach - element
    cityHasState1.forEach { element -> println("${element.key}, ${element.value}") }

    //5. using iterator
    val locationIterator = cityHasState1.iterator()
    //locationIterator.remove() //Illegal state exception - move to first element
    println(locationIterator.hasNext())
    locationIterator.next() //now it can remove
    locationIterator.remove() //only is map is mutable & iterated to next
    println(locationIterator.next())
    println(locationIterator.next())
    //println(locationIterator.next())
    println(locationIterator.hasNext())
    //println(locationIterator.next()) //No SuchElement Exception

    val cityIterator = cityHasState1.iterator()
    while (cityIterator.hasNext()) {
        println(cityIterator.next())
    }
    //Use with caution
    val iteratorForCityStates = cityHasState1.iterator()
    while (iteratorForCityStates.hasNext()) {
        val element = iteratorForCityStates.next()
        //println("${iteratorForCityStates.next().key} -> ${iteratorForCityStates.next().value}") //invalid: iterated next twice
        println("${element.key} -> ${element.value}")

    }

    //list iterator - next index, prev index,
    val numbers = listOf("One", "Two", "Three", "Four")
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext())
        print("${listIterator.next()}, ")
    println("Iterating backwards")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(" - ${listIterator.previous()}")

    }
}