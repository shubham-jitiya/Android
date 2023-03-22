package LearnKotlin

fun main() {
    print("Hello, ")
    print("World")

    //automatically adds new line
    println("Any print statement below this line will be printed on new line")
    print("Test")

    //1. Functions ------------------------------------------------------------------|
    //Function: with two Int parameters and Int return type.
    fun sum(a: Int, b: Int): Int {
        return a + b;
    }
    println("\nSum: ${sum(5, 2)}")

    //A function body can be an expression. Its return type is inferred.
    fun sumInferred(a: Int, b: Int) = a + b
    println("Sum: ${sumInferred(5, 2)}")

    //returns no meaningful value
    fun printSum1(a: Int, b: Int): Unit {
        println("${a + b}")
    }
    printSum1(-1, 8)

    //Unit return type can be omitted.
    fun printSum2(a: Int, b: Int) {
        println("${a + b}")
    }
    printSum2(-1, 8)

    //2. Variables ------------------------------------------------------------------|
    //Already done in KotlinBasics

    //3. Creating classes and instances ---------------------------------------------|
    //define a class
    class Shape

    //Properties of a class can be listed in its declaration or body.
    class Rectangle(var height: Double, var length: Double) {
        var perimeter = (height + length) * 2
    }

    //Inheritance  ------------------------------------------------------------------|
    open class ShapeTwo
    class RectangleTwo(var height: Int) : ShapeTwo() {
        //class body
    }

    //Single line comment  ----------------------------------------------------------|
    /* Multiline comment */

    //String template  --------------------------------------------------------------|
    var a = 1
    val str1 = "a is $a"
    a = 2
    println("${str1.replace("is", "was")}, but now is $a")

    //Conditional expression -------------------------------------------------------|
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }
    //Above fn can be simplified
    fun maxOfModified(a: Int, b: Int) = if (a > b) a else b
    println(maxOfModified(5, 10))

    //for loop, while, when ---------------------------------------------|
    //Already covered in kotlin basics

    //Ranges ------------------------------------------------------------|


}