package LearnKotlin

import java.io.File
import javax.crypto.SealedObject
import javax.sql.DataSource

fun main() {

    //1. Basics
    var circle = Shape.Circle(2.0f)
    var square = Shape.Square(2)
    var recta = Shape.Square(2)


    //2.
    var tile1: Tile = Red("Mashroom", 25) //This is reference of Tile
    var tile2 = Blue(100)
    //println("Tile type: ${tile1.type} | Tile points: ${tile2.points}") //type & points are in Red class not Tile

    //using when
    val points = when (tile1) {
        is Red -> tile1.points * 2
        is Blue -> tile1.points * 5
    }
    println(points) //50
}

//enum restrictions
enum class Color(val colorShade: String) {
    RED("Light red"),
    GREEN("Light green"),
    BLUE("Light blue"),
    //BLACK(val darkShare: String) //Invalid: To overcome use sealed classes
}


//sealed class - can put internal classes inside or outside of sealed class
sealed class Shape {
    var color: String = ""

    //we can have
    data class Circle(var radius: Float) : Shape() //can have data class
    sealed interface CircleInterface
    sealed class NestedSealedClass()
    object ObjectDeclaration : Shape()

    class Square(var side: Int) : Shape()
    class Rectangle(var length: Int, var breadth: Int) : Shape() {}

}
//outside
//class Circle(var radius: Float) : Shape()
//class Square(var side: Int) : Shape()
//class Rectangle(var length: Int, var breadth: Int) : Shape()


//Ex. 2
sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()


//Can you inherit from a sealed class outside of its declaration file
// check enum main fn for execution
sealed class Animal {
    open var name: String = ""

    open class Mammal() : Animal() {
        override var name: String
            get() = super.name
            set(value) {}
    }

    open class Birds() : Animal()
    //abstract fun drive()
}


//Ex. 3 Constructor

//(no restriction)class > sealed > enum (restricted more)