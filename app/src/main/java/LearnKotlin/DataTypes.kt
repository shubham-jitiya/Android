package LearnKotlin

fun main() {
    //Numbers --------------------------------------|
    //jvmOptimisation()
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //val b: Int = 127
    val b: Int = 128
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false if range exceeds 127

    println(b == b) //true

    //Explicit number conversion
    // Hypothetical code, does not actually compile:
    val a1: Int? = 1 // A boxed Int (java.lang.Integer)
    val b1: Long? = a1?.toLong() // Error - need to cast
    //print(b1 == a1) //  Can't check of different type

    //Nullable

    println("Check: ${-0.0 == 0.0}")

    //Characters --------------------------------------|
    //if character variable is a digit
    var charS = '1'
    var numOne: Int = charS.digitToInt()
    println(numOne)

    //String --------------------------------------|
    //String is char arr
    var name = "Shubham"
    for (char in name) {
        print("$char, ")
    }

    //can access index based as it is array
    println("\n0th element: ${name[0]}")

    //immutable
    var name2 = "Old Value"
    println(name2.hashCode())
    name2 = "New Value" //But we can change
    println(name2.hashCode())
    name2 = "New2 Value" //But we can change
    println(name2.hashCode())
    //name[0] = '' //We can't modify its particular char

    println(charS)
    var newStr = name2.uppercase()
    println(newStr)

    //trim margin
    val text = """
    |
    |Tell me and I forget.
    |   Teach me and I remember.
    |       Involve me and I learn.
    |(Benjamin Franklin)
    |
    """.trimMargin()
    println(text)

    //string template with raw
    var price = """
        ${'$'}_9.99
    """.trimIndent()
    println(price)

    //Array --------------------------------------|
    //primitive arrary
    var x: IntArray = intArrayOf(1, 2, 3)

    //var x2 = intArrayOf(5) //intArrayOf is different from IntArray
    var x2 = IntArray(5) //size 5 with 0 elements
    println(x2.size)

    var x3 = IntArray(5) { it * 2 } //lambda
    for (x in x3) {
        println(x)
    }
}
