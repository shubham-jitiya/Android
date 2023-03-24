package LearnKotlin.collection

//Filtering: Filter - plus/minus
fun main() {
    //filter with list
    var people = listOf<PersonData>(
        PersonData("Jitiya", "Shubham", 21),
        PersonData("Trivedi", "Bhakti", 23),
        PersonData("Sartanpara", "Shyam", 20),
        PersonData("Vyas", "Divyesh", 13),
        PersonData("Nagpurkar", "Manthan", 16)
    )

    //var filter = people.filter { it.age < 21 }                //1
    //println(filter)
    people.filter { it.age < 21 }.forEach { println("$it") }   //2

    //filter with map
    var cityHasState = buildMap<String, String> {
        put("Bengaluru", "Karnataka")
        put("Chennai", "Tamilnadu")
        put("Ahmedabad", "Gujarat")
    }
    var filterAhmedabad = cityHasState.filter { entry -> entry.key.equals("Ahmedabad") } //1
    println(filterAhmedabad)
    println(filterAhmedabad.filter { it.key.equals("Ahmedabad") }) //2

    //filter even number
    var numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers)
    //filter odd numbers
    var oddNumbers = numbers.filterNot { it % 2 == 0 }
    println(oddNumbers)

    //filter is instance

    //partition
    var partitionNumbers = numbers.partition { it % 2 == 0 }
    println(partitionNumbers.first) //even
    println(partitionNumbers.second) //odd

    //test predicates: any, none, all
    var isAgeTwenty = people.any { it.age == 20 }
    println("People with age 20 exist: $isAgeTwenty")
    var noneAgeBelowEighteen = people.none { it.age <= 18 }
    println("Nobody is below eighteen age: $noneAgeBelowEighteen")
    var allPeopleIsAdult = people.all { it.age in 11..58 }
    println("Is all people adult: $allPeopleIsAdult")

    //plus minus
    var cart1 = listOf<String>("Apple", "Banana")
    var cart2 = listOf<String>("Milk")
    var addTwoCartItems = cart1 + cart2 //add two list
    var addItemToCart2 = cart2 + "Bread" //add individual elements
    println(addItemToCart2)

    println(addTwoCartItems)
    addTwoCartItems = cart1 - cart2 //remove `milk` from list
    //var addItemToCart2 = cart2 + "Bread" //add individual elements
    println("cart 2 removed from list: $addTwoCartItems")
}