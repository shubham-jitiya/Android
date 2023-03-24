package LearnKotlin

/*
Type checking and smart casting
*/

fun main() {

    //Basic example - Type check
    var circle = Circle()
    var square = Square()

    if (circle is Circle) {
        println("Is it of Circle class")
    }

    //usecase: Array of object
    //var shapes = arrayOf(circle) //Type Circle
    var shapes = arrayOf(circle, square) //Gives common types - NewShape as both inherits NewShape

    //Type check - is operator
    for (element in shapes) {
        if (element is Circle) {
            //smart-cast: we get members of circle class only
            println("It is circle class")
        } else if (element is Square) {
            println("It is square class")
        } else {
            println("Type is undefined")
        }
    }

    //Type-cast - as operator
    for (element in shapes) {
        if (element is Circle) {
            //smart-cast: we get members of circle class only
            println("It is circle class")
        } else {
            //Type cast - we get members of square class only
            (element as Square).squareProperty1
            println("If it is not circle then it is type casted to Square class")
        }
    }

    //Type caste only after type checking
    //We may get error is type casted without type checking
    var mango = Mango()
    var shape = arrayOf(circle, square, mango) //Gives Any types -as every class inherits Any class
    for (element in shape) {
        if (element is Circle) {
            println("It is circle class") //type check
            //now you can type cast
        } else if (element is Square) {
            println("It is square")
            //now you can type cast
        }
        //Type casting without type checking
        //Error: can not cast to circle
        //(mango as Circle).getArea()
    }

    //type check with nullable
    var nullableString: String? = null

    // Cast nullable string to non-null string using as operator
    //if not used String? we may get exception
    //val nonNullString: String = nullableString as String //unsafe
    val nonNullString: String? = nullableString as String?

    // Print the non-null string
    println(nonNullString)

    //type check with when
//    var x = 100
//    var result = when (x) {
//        is Int -> print(x + 1)
//        is String -> print(x.length + 1)
//        is IntArray -> print(x.sum())
//    }
    val myString: String = "123"

    val myInt: Int = when (val temp = myString.toIntOrNull()) {
        null -> 0 // if the string can't be parsed as an Int, return 0
        else -> temp // otherwise, return the parsed Int value
    }
    println(myInt)

}

open class NewShape()
class Circle() : NewShape() {
    var circleProperty1: Int = 0
    fun getArea() {}
}

class Square() : NewShape() {
    var squareProperty1: Int = 0
    fun getAreaOfSquare() {}
}

class Mango()
class Banana()
class Kiwi