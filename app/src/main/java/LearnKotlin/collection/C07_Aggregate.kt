package LearnKotlin.collection

import LearnKotlin.sum

//Grouping: Aggregate, Fold, Reduce
/*
* Fold vs reduce:
*   - fold takes initial value
*   - reduce takes first element as its value
*
* */
fun main() {
    var people = listOf<PersonData>(
        PersonData("Jitiya", "Shubham", 21),
        PersonData("Trivedi", "Bhakti", 23),
        PersonData("Sartanpara", "Shyam", 20),
        PersonData("Vyas", "Divyesh", 20),
        PersonData("Nagpurkar", "Manthan", 16)
    )

    //fold
    val countAllAges = people.fold(0) { acc, personData -> acc + personData.age }
    //println(countAllAges)
    println("1. Avg age: ${countAllAges / people.count()}") //1

    //Simple example
    val numbers =
        listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) //can not use ranges like we do in swift
    val sumOfNumbers = numbers.fold(0) { acc, i -> acc + i }
    println("2. $sumOfNumbers") //2
    val productOfNumbers = numbers.fold(1) { acc, i -> acc * i }
    println("3. $productOfNumbers") //3

    //reduce
    //difference between reduce & fold: reduce takes first element as initial value, in fold we give initial value
    val sumOfNum = numbers.reduceRight { acc, element -> acc + element }
    println("4. $sumOfNum") //4

    //aggregate fun - min, max, age, count,
    println("5. ${numbers.min()}") //5
    println("6. ${numbers.max()}") //6
    println("7. ${numbers.average()}") //7
    println("8. ${numbers.sum()}") //8
    println("9. ${people.sumOf { it.age }}") //9
    println("10. ${people.minOf { it.age }}") //10
    //minOrNull?
}