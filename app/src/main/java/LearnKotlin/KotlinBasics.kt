package LearnKotlin

import kotlinx.coroutines.processNextEventInCurrentThread
import kotlin.reflect.typeOf

fun main() {
    //1. Define variables ----------------------------------------------|
    //1. immediate assignment
    val num: Int = 100 //Immutable - can not reassign

    //2. `Int` type is inferred
    var sumOfNumber = 100 ///mutable

    //3. Type is required when no initailiser is provided
    var sum: Int
    val total: Int

    //deferred assignment
    total = 3

    //2. Types ----------------------------------------------|
    val myByte: Byte = 10
    val myShort: Short = 120
    val marks = 90
    val myMarks = 90L //`L` represents long
    val myFloat = 132.4f //`f` or `F`
    val myBool = true
    val letter = 'S'
    val digitChar = '1'

    //3. Arrays ----------------------------------------------|
    var numbers = arrayOf(1, 2, 3, 4, 5)
    var colors = arrayOf("red", "green", "white", "blue")

    //primitive arrays
    val myCharArr = charArrayOf('S', 'H', 'U', 'B', 'H', 'A', 'M')
    val myIntArr = intArrayOf(1, 2, 3, 4, 5)

    //Array constructor
    val numbersArray = Array(5, { i -> i * 2 })
    println(numbersArray[0])
    println("Total elements: ${numbersArray.size}")

    //4. String interpolation ----------------------------------------------|
    //$ & ${ } & """
    val firstWorld = "Learn"
    val secondWorld = "Kotlin"
    var concate = "$firstWorld $secondWorld"
    println(concate)
    println(""""This"""")

    //5. Control flow ----------------------------------------------|
    //If - expression, for - can use with index, while - same
    val number = 0
    var result = if (number > 0) {
        "Positive integer"
    } else if (number < 0) {
        "Negative integer"
    } else {
        "Zero" //<--- Output
    }

    println(result)

    //when - replaces switch
    var firstValue = 5
    var secondValue = 2
    var operator = "+"
    var resultSem1 = when (operator) {
        "+" -> firstValue + secondValue
        "-" -> firstValue - secondValue
        "*" -> firstValue * secondValue
        "/" -> firstValue / secondValue
        else -> "$operator is invalid"
    }
    println(resultSem1)

    //When with range
    var age = 13
    when (age) {
        in 1..18 -> println("Age is in the range")
        !in 18..110 -> println("Age is out of range")
        else -> print("None of the above")
    }

    //when with check type
    var newSum = 123
    when (newSum) {
        is Int -> println("Integer value is $newSum")
        else -> println("It is not a integer")
    }

    //for
    for (i in 1..5) {
        print("$i,  ")
    }
    //for with steps
    print("\n")
    for (i in 10 downTo 0 step 2) {
        print("$i, ")
    }

    //for with index
    var cities = arrayOf("Ahmedabad", "Vadodra", "Surat", "Rajkot")
    print("\n")
    for (city in cities) {
        print("$city - ")
    }

    print("\n")
    for (index in cities.indices) {
        print("${cities[index]} -- ")
    }
    print("\n")
    var reverseCount = 5
    while (reverseCount > 0) {
        print("$reverseCount, ")
        reverseCount--
    }
    reverseCount = 5
    println()
    do {
        print("$reverseCount, ")
        reverseCount--
    } while (reverseCount > 0)

    //6. Equality Check ----------------------------------------------|
    //structural equality - == (same values?)
    // referential equality - === (points to same memory location?)
    val countries = setOf("Java", "Javascript", "Swift")
    val neighbours = setOf("Swift", "Javascript", "Java")
    println()
    println(countries == neighbours) //have same value - true
    println(countries === neighbours) //but different reference - false

    //7. Null safety ----------------------------------------------|
    val trainingName: String? = "Learn kotlin in 45 minutes"
    if (trainingName != null && trainingName.isNotEmpty()) {
        println("String of length ${trainingName.length}")
    } else {
        println("String is empty")
    }

    val platform: String? = null
    val language = "Kotlin"

    println(platform?.length) // safe call
    println(language?.length) // unnecessary safe call

    //val lengthOfWord = platform!!.length // !! operator - crashes

    //Elvis operator
    var name: String? = null
    var lengthOfName = name?.length ?: -1
    println(lengthOfName)

}