package LearnKotlin.collection

//Transformation: Associate, flatten, join to string
fun main() {
    var people = listOf<PersonData>(
        PersonData("Jitiya", "Shubham", 21),
        PersonData("Trivedi", "Bhakti", 23),
        PersonData("Sartanpara", "Shyam", 20),
        PersonData("Vyas", "Divyesh", 20)
    )
    var associatedList1 = people.associate { it -> Pair(it.firstName + it.lastName, it) }
    //var associatedList1 = people.associateBy { "${it.firstName}${it.lastName}"} //same as above
    println(associatedList1)

    //returns map with string as a key
    var associatedList2 = people.associateBy { it.firstName }
    println(associatedList2)


    //Flatten
    var cart1 = listOf<String>("Mango", "Banana")
    var cart2 = listOf<String>("Apple", "Orange")
    var cart3 = listOf<String>("Watermelon", "Pomegranate")
    var allItems = listOf(cart1, cart2, cart3)
    println(allItems)
    var singleBag = allItems.flatten() //returns single list
    println(singleBag)
    println("Bag: ${allItems.flatten().filter { it == "Mango" || it == "Orange" || it == "Watermelon"}}")

    //String presentation
    var itemNames = singleBag.joinToString(
        " - ",
        prefix = "Thanks for purchasing the below items\n",
        postfix = "\nHope to see you again"
    )
    println(itemNames)
}