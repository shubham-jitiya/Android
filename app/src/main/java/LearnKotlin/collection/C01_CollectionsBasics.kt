package LearnKotlin

fun main() {
    //LIST --------------------------------------------------------------
    //1. both are immutable list
    var cart1 = listOf<String>("Apple", "Banana", "Kiwi", "Orange")
    var cart2 = buildList<String> {
        add("Apple")
        add("Banana")
        add("Kiwi")
        add("Orange")
    }
    //cart1.add("Pineapple") //Invalid
    //cart2.add("Pineapple") //Invalid

    //1.1 mutable list
    var cart3 = mutableListOf<String>("Apple", "Banana", "Kiwi", "Orange")
    cart3.add("Pineapple") //always added at last
    cart3.add("Pineapple") //can contain duplicates
    println(cart3) //[Strawberry, Apple, Banana, Kiwi, Orange, Pineapple, Pineapple]
    cart3.add(0, "Strawberry") //at index
    println(cart3) //[Strawberry, Apple, Banana, Kiwi, Orange, Pineapple, Pineapple]


    //SET --------------------------------------------------------------
    //1. both are immutable set
    var cart4 = setOf<String>("Apple", "Banana", "Kiwi", "Orange")
    var cart5 = buildSet<String> {
        add("Apple")
        add("Banana")
        add("Kiwi")
        add("Orange")
    }
    //cart4.add("Pineapple") //Invalid
    //cart5.add("Pineapple") //Invalid

    //1.1 mutable set
    var cart6 = mutableSetOf<String>("Apple", "Banana", "Kiwi", "Orange")
    cart6.add("Pineapple") //always added at last
    cart6.add("Pineapple") //doesn't allow duplicates - no compile time error
    println(cart6) //is it really unordered?
    //cart6.add(0, "Strawberry") //can not add `at index` because elements are unordered


    //MAP --------------------------------------------------------------
    //1. both are immutable map - no put or add method
    var cityHasState1 = mapOf<String, String>(
        "Bengaluru" to "Karnataka",
        "Chennai" to "Tamilnadu",
        "Ahmedabad" to "Gujarat"
    )
    var cityHasState2 = buildMap<String, String> {
        put("Bengaluru", "Karnataka")
        put("Chennai", "Tamilnadu")
        put("Ahmedabad", "Gujarat")
    }
    println(cityHasState1)
    println(cityHasState2)

    //2. mutable map
    var cityHasState3 = mutableMapOf<String, String>(
        "Bengaluru" to "Karnataka",
        "Chennai" to "Tamilnadu",
        "Ahmedabad" to "Gujarat"
    )
    cityHasState3.put("Mumbai", "Maharashtra") //added at last
    println(cityHasState3)
}