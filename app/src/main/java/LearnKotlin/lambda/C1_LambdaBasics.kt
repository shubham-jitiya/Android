package LearnKotlin

import kotlin.math.pow

/*
    higher order function & lambdas
*/

fun main() {
    var sumFun = ::sum
    var powerFun: (arg1: Double, arg2: Double) -> Double = ::power

    println(sumFun(10.0, 20.0))
    println(powerFun(2.0, 3.0))

    //can only be able to pass sum because sum have same parameters as closure requires
    //can not pass fun if it is not of type double
    val result = calculator(5.0, 2.0, ::sum)
    println(result)


    //define lambda
    val sumLambda = { num1: Int, num2: Int -> num1 + num2 }
    println(sumLambda(10, 2))

    //Multiline lambda - Unit return type
    val multiLine = { num1: Int, num2: Int ->
        println("Result: ${num1 + num2}")
    }
    multiLine(10, 3)

    //lambda with type - if we are giving type explicitly then we can skip inside lambda
    val withType: (Int, Int) -> Int = { x: Int, y -> x + y }
    println(withType(15, 5))

    //simplify lambda
    val calSquare = { x: Int, y: Int -> x + y }
    val calcSquare: (Int) -> Int = { it + it } //Simplified but must have type

    //lambda as last parameter - we can write after fun call
    val sum2 = calculator(10.0, 1.0, { num1, num2 -> num1 + num2 })
    val sum = calculator(10.0, 1.0) { num1, num2 -> num1 + num2 }
    println(sum)

}

//Normal function
fun sum(num1: Double, num2: Double): Double {
    return num1 + num2
}

fun power(num1: Double, num2: Double): Double {
    return num1.pow(num2)
}

//Higher order functions
fun calculator(num1: Double, num2: Double, sum: (Double, Double) -> Double): Double {
    val result = sum(num1, num2)
    return result
}