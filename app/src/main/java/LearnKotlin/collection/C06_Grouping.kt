package LearnKotlin.collection

/*
* groupBy
*   - returns map
*   - we can decide key value based on condition using keySelector & valueTransform
*   - transformations can be applied
*
* groupingBy
*   - returns Grouping object
*   - eachCount()
* */

fun main() {
    var people = listOf<PersonData>(
        PersonData("Jitiya", "Shubham", 21),
        PersonData("Trivedi", "Bhakti", 23),
        PersonData("Sartanpara", "Shyam", 20),
        PersonData("Vyas", "Divyesh", 20),
        PersonData("Nagpurkar", "Manthan", 16)
    )
    val ageGroups = people.groupBy { it.age }
    println("1 - $ageGroups") //1
    val ageGrouping = people.groupingBy { it.age }
    println("1.1 - ${ageGrouping.eachCount()}") //1.1

    val ageGroupTeenager = people.groupBy { it.age <= 20 }
    println("2 - $ageGroupTeenager") //2. grouped by true (satisfying the condition) & false (not satisfying the condition)
    val ageGroupingTeenager = people.groupingBy { it.age <= 20 }
    println("2.1 ${ageGroupingTeenager.eachCount()}") //we can transform this
    val transformedMap = people.groupBy(keySelector = { if (it.age <= 20) "Major" else "Minor" },
        valueTransform = { "${it.firstName} ${it.lastName}" }) // we write condition how we want our keys & values
    println("2.2 $transformedMap")

    val groupByFirstAlphabet = people.groupBy { it.firstName.get(0) }
    println("3 - $groupByFirstAlphabet") //3
}