package LearnKotlin

import java.math.BigInteger

fun main() {

    //Returns Unit
    birthdayGreeting()

    //Return String
    val wish = birthdayGreeting2()
    println(wish)
    println(wish) //print returning value directly

    //Multiple parameters
    val wish2 = birthdayGreeting("Shubham", "Happy birthday")
    println("Multiple parameters: $wish2")

    //Multiple different parameters
    val wish3 = birthdayGreeting("Shubham", 22)
    println(wish3)

    //Named argument
    val wish4 = birthdayGreeting(age = 21, name = "Shubham")
    println(wish4)
    //skip named argument
    greet("Shubham")
    //with nullable
    //getStudentData(enroll = 100) //nullable is first parameter - use named argument
    //getStudentData(enroll = 100, age = 21) //nullable in between - use named argument
    getStudentData(100) //nullable is the last parameter - skip named argument

    //default argument
    val wish5 = birthdayGreeting2(age = 13)
    //val wish5 = birthdayGreeting2(13) //Invalid
    println(wish5)

    //With lambda
    foo(1) { println("hello") }     // Uses the default value baz = 1?
    foo(qux = { println("hello") }) // Uses both default values bar = 0 and baz = 1
    foo { println("hello") }        // Uses both default values bar = 0 and baz = 1

    //Variable argument
    variableArguments("a", "b", "c")
    val num = intArrayOf(1, 2, 3)
    //variableArguments(alphabets = *arrayOf("A", "B", "C")) //redundant spread operator
    //spreadOperator(numbers = *num.toTypedArray()) //redundant spread operator

    //Single expression
    println(double(5))

    //infix
    val num1 = 10
    val num2 = 20
    val greater = num1 isGreater num2 //infix function
    println("Greater: ${num1.isGreater(20)}")
    println("Using infix: $greater")

    //infix - check one string contains another
    val str1 = "This is the first sentence"
    val str2 = "first"
    println(str1 containsString str2)

    //infix - member function
    val mango = FruitA()
    mango.getInfo()

    //TailRec
    //0 1 1 2 3 5 8 13 21
    //stack overflow - out of stack memory
    val result = findFibonacciNumber(100000, BigInteger("1"), BigInteger("0"))
    println("Fibonacci: $result")

    //var arg
    varArg(1, 2,3,4, num2 = 111)

    //elvis operator
    fooBar()
}

//1. How to define and call your own functions
fun birthdayGreeting() {
    println("Happy Birthday, Shubham")
    println("Now you are 21 years old!")
}


//2. How to return values from a function that you can store in a variable.
fun unitReturnType(): Unit {}

//Return String
fun birthdayGreeting2(): String {
    val nameGreeting = "Shubham"
    val message = "Happy birthday"
    return "$message $nameGreeting"
}


//3. Add a parameter to the birthdayGreeting() function
fun birthdayGreeting(name: String, message: String): String {
    //name = "HACKED" //parameters are immutable: val
    return "$message, $name"
}

//parameter of different types
fun birthdayGreeting(name: String, age: Int): String {
    //name = "HACKED" //parameters are immutable: val
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old"
    return "$nameGreeting, $ageGreeting"
}


//4. Named arguments
//except first parameter rest all have default values then skip named argument
fun greet(name: String, msg: String = "Good morning!") {
    println("$msg $name")
}
//with nullable
//1. nullable is first parameter
//fun getStudentData(name: String? = null, enroll: Int) {
//    println("$enroll")
//}

//2. nullable in between
//fun getStudentData(enroll: Int, name: String? = null, age: Int) {
//    println("$enroll")
//}

//if nullable is the last parameter then no need to use named parameter
fun getStudentData(enroll: Int, name: String? = null) {
    println("$enroll")
}

//5. Default argument
fun birthdayGreeting2(name: String = "Shubham", age: Int): String {
    //name = "HACKED" //parameters are immutable: val
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old"
    return "$nameGreeting, $ageGreeting"
}

//with overriding - // No default value is allowed
open class PersonCollege {
    open fun getInfo(firstName: String = "NA", lastName: String, age: Int) {}
}

class Student2 : PersonCollege() {
    //we can not pass default value to overriding method
//    override fun getInfo(firstName: String = 'NA', lastName: String, age: Int) {
//        super.getInfo(firstName, lastName, age)
//    }
}

//with Lambda
fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) {
}


//6. Var args
fun variableArguments(vararg alphabets: String) {
    val numberOfParameter = alphabets.size
    val firstParameter = alphabets.get(0)
    val secondParameter = alphabets.get(1)
    val thirdParameter = alphabets.get(2)
    println("Number of parameter: $numberOfParameter | 1st: $firstParameter | 2nd: $secondParameter | 3rd: $thirdParameter")
    println(alphabets)
}

fun spreadOperator(vararg numbers: Int) {
    println(numbers)
}

//7. Single expression fun
fun double(x: Int) = x * 2

//8. Infix notation - all infix functions are extension but all extension may not be infix fun
//Error: Can not be extension, because infix can have only 1 parameter
//infix fun String.add(str1: String, str2: String) { }
infix fun Int.isGreater(num2: Int): Int {
    if (this > num2) {
        return this
    } else {
        return num2
    }
}

//eg. infix function to check one string contains the another string
infix fun String.containsString(another: String): Boolean {
    return this.contains(another)
}

//infix with member function
class FruitA() {
    infix fun getName(code: Int) {
        println("Fruit Code: $code")
    }

    fun getInfo() {
        this getName 101 //Valid
        getName(50) //Valid
        //getName 01 //Invalid
    }
}

//9. TailRec
//if tailrec is removed we may get stack overflow exception for large num like 10000
tailrec fun findFibonacciNumber(n: Int, current: BigInteger, prev: BigInteger): BigInteger {
    if (n == 0) {
        return prev
    } else {
        return findFibonacciNumber(n - 1, current + prev, current)
    }
}

fun varArg(num1: Int, vararg arr: Int, num2: Int){
    println(num1)
    arr.forEach { print(it) }.also { println() }
    println(num2)
}

//elvis operator
var a = true
//var a: Boolean? = true
fun fooBar() {
    a ?: return
    println("FooBar")
}

var num1: Int? = 100
var str: String = "TEST"
val res = num1 ?: str