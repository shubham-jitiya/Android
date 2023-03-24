package LearnKotlin

fun main() {
    println(addNum(6, 1))

    //Type alias with classes
    val newStudent = Indian("Shubham").name
    println(newStudent)
    val oldStudent = std("Jitiya").name
    println(oldStudent)
}

//How can we give type alias to the class that receives a constructor
typealias std = Indian

//Ex.2

//Ex 1. Type alias for fun return type - Int as int
typealias int = Int

fun addNum(num1: int, num2: int): int {
    val sum = num1 + num2
    return sum
}

//Ex 2. for inner class
class Indian(val name: String) {
    object Students {
        val name: String? = null
    }

}

class Foreigner {
    inner class Inner
}
