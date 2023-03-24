package LearnKotlin

//public is redundant - it is by default
public fun run() {}
public class Mammals {}


//Only accessible inside this file but can not be redeclare
private fun walk() {}
private class Bird {}


//internal - everywhere under same module
internal fun teach() {}
internal class Teacher {}


//protected - not applicable to top level
//protected fun sit() {}
//protected class Dog {}

//Ex. 1
open class Cat {
    //All properties are final by default
    private var isVegiterian: Boolean = false
    protected var breed: String = "NA"
    internal var color: String = "White" //This can not be overrided

    // internal open var color: String = "" //This can be overrided
    public var name: String = "Pet"
}

class PersianCat : Cat() {
    //override var color = ""

    //We can not access property over here but we can access inside functions
    // breed = "" //invalid
    fun info() {
        println("Breed: ${breed}") //Can access here
        //println("Is vegiterian: ${isVegitarian}") //Inaccessible
        println("Color: ${color}")
        println("Name: ${name}")
    }
}

//Try to access the properties of Cat in another class  without inheriting
class IndianCat {
    fun getInfo() {
        var myPet = Cat()
        //println("Breed: ${myPet.breed}") //Not accessible
        //println("Is vegiterian: ${isVegitarian}") //Not accessible
        println("Color: ${myPet.color}")
        println("Name: ${myPet.name}")
    }
}


//private with constructors
class IndianDog private constructor(val name: String) {}

fun main() {

}
