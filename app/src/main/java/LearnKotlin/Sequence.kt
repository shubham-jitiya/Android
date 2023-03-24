package LearnKotlin

fun main() {
    //construct
    val numberSequence = sequenceOf("One", "Two", "Three")
    numberSequence.forEach { println(it) }

    //already have iteratable object
    val numbers = listOf("one", "two", "three", "four")
    val numListSeq = numbers.asSequence()

    //crete sequence from fun
    val oddNumbers = generateSequence(1) { it + 2 }
    println(oddNumbers.take(5).toList())

    //println("Count: ${oddNumbers.count()}") //count overflow
    //Fix overflow by providing null
    val oddNumbersFinite = generateSequence(1) { if (it < 8) it + 2 else null }
    oddNumbersFinite.forEach { println(it) }
    println(oddNumbersFinite.count())


}
