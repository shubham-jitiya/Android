package LearnKotlin

import kotlinx.coroutines.processNextEventInCurrentThread


//Classes and objects
/*
Type checking and casting
   - Properties / fields
        - Object knows (state)
        - eg. Car has a name
   - Methods
        - Object does (behaviour)
        - eg. car can apply breaks
*/

fun main() {
//
//    val person = Person(name = "Shubham", 10)
//    //println(person.child)

    //Properties & methods
    val i20 = Car(name = "i20", type = "petrol", range = 25)
    i20.applyBrakes()

    i20.range = 50
    println(i20.range) //50

    //Check if person can vote
    val shubham = Person(name = "Shubham", age = 13)
    println(shubham.canVote())

    val bagOne = Luggage()
    println(bagOne.capacity)

    //we can modify class properties directly without constructor
    bagOne.weight = 25
    println("Luggage weight: ${bagOne.weight}") //25

    //Now we can modify & reassign
    val luggage2 = Luggage2(15, 5)
    println(luggage2.currentLoad)
    luggage2.currentLoad = 10
    println(luggage2.currentLoad) //Updated: 10
    print(luggage2.maxCapacity)
    //luggage2.weight //We can not access property of primary constructor

    //Initialiser
    val testInitialiser = InitOrderDemo(name = "Shubham")

    //Delegation

    //Implicit delegation
    val implicitDelegation = ImplicitDelegation(5);

    //with inner class
    //val classA = ClassA.ClassB.ClassD //We can't create instance of it
    //print("On level: ${classA.property3}") //because we have used inner

    //without inner class
    val classA1 = ClassA1.ClassB1.ClassC1() //Now we can crate
    print("On level: ${classA1.property3}") //because it's nested classes are not inner

    //implicit this
    fun printLine() {
        println("Top level function")
    }

    class ImplicitThis {
        fun printLine() {
            println("\nMember function")
        }

        fun invokePrintLine(omitThis: Boolean = false) {
            if (omitThis) printLine() //Default: Top level
            else this.printLine() //instance
        }
    }

//    val implicitThis = ImplicitThis()
//    implicitThis.printLine()
//    implicitThis.invokePrintLine(true)
    ImplicitThis().invokePrintLine() // Member function
    ImplicitThis().invokePrintLine(omitThis = true) // Top-level function

    //Object keyword - object declaration
    //val objectKeyword = ObjA() //Can not create instance
    println(ObjA.num)
    println(ObjB.num2)

    //Singleton object
    Singleton.insights() //Insta like: 0, Fb likes: 0
    Singleton.incrementInstaLikes()
    Singleton.incrementFbLikes()
    Singleton.insights() //Insta like: 1, Fb likes: 1
    println(Singleton) //object with its hash

    //Object expression: Anonymous object
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"

        //By default it returns hash value if we print reference, so we need to override toString method
        override fun toString(): String {
            return "${hello}, ${world}"
        }
    }
    println(helloWorld) //Hello, World

    //Use case: 1
    //Implement interface without creating class
    val cloneableInterface1 = object : Cloneable {
        override fun clone() {
            println("Clone method of cloneable interface called ")
        }
    }
    cloneableInterface1.clone()

    //inherit classes without creating classes
    val inheritClass = object : InheritWithoutClass() {
        fun anonymousFoo() {
            println("Anonymous function called")
        }
        //we can also override methods
    }
    inheritClass.foo()
    inheritClass.anonymousFoo()

    //Difference init & constructor
    val test = Test() //called init, then called constructor

    //companion object
    println("Accessing object value: ${Value.PI}")
    //can not be accessed if not declared as `companion object`
    println("Accessing companion object value: ${ValueCompanion.PI}")
}

class Car(val name: String, val type: String, var range: Int) {
    fun applyBrakes() {
        print("Brakes applied")
    }

    fun increaseSpeed() {
        print("Increased speed")
    }
}

//class with primary constructors
class Person(val name: String, var age: Int) {
    //    val child = Person(name, age) //Gives error
    fun canVote(): Boolean {
        return age > 18
    }
}

class Person3(val name: String, var age: Int = 0) {
    fun canVote(): Boolean {
        return age > 18
    }
}

//Primary constructors with default values:
// Type inference won't work while assigning default value must define type
//class Person2(val firstName: String, val lastName: String, var isEmployed = false) //Invalid
class Person2(
    val firstName: String, val lastName: String, var isEmployed: Boolean = false
)

//constructor keyword: When we use annotations or access modifiers
//Invalid: //class Customer public  (name: String) { /*...*/ }
class Customer public constructor(name: String) { /*...*/ }

//Empty constructors
class Useless {}
class Uselesss2


//constructors: with no primary parameter
class Luggage() {
    val capacity = 30
    var weight = 20
}

//Operations can be performed
class Luggage2(capacity: Int, weight: Int) {
    val maxCapacity: String = "Max capacity: $capacity"
    var currentLoad = weight


}

//with initializer
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also { println() }

    init {
        println("First initialiser block that prints $firstProperty")
    }

    val secondProperty = "Second property: ${name.length}"

    init {
        println("Second initialiser block that prints ${name.length}")
    }
}

//secondary constructor
class Person4(val pets: MutableList<Pet> = mutableListOf())
class Pet {
    constructor(owner: Person4) {
        owner.pets.add(this)
    }
}

//constructor delegation
class Person5(val name: String, val firstName: String) {
    val children: MutableList<Person5> = mutableListOf()

    constructor(name: String, firstName: String, parent: Person5) : this(name, firstName) {
        parent.children.add(this)
    }
}

//Implicit delegation: delegate even if no primary constructor is present
class ImplicitDelegation {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

//By default auto generated constructor is public with no argument- make it private
class DontCreateMe private constructor() {}

//Nested: any combination of interface & class is possible
interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}


//Inner class - inner must have all nested class as inner
/*
class ClassA {
    val property1: Int = 1

    inner class ClassB {
        val property2: Int = 2
        fun foo() {
            //this@ClassA.property1

        }
        //Error - must have inner
        class ClassC {
            val property3: Int = 3
            fun foo3() {

            }
        //Must have inner
            class ClassD {
                val property4: Int = 4
                fun foo4() {
                    //this@ClassA.property1
                }
            }
        }
    }
}*/

class ClassA {
    val property1: Int = 1

    inner class ClassB {
        val property2: Int = 2
        fun foo() {
            //this@ClassA.property1

        }

        //Error - must have inner
        inner class ClassC {
            val property3: Int = 3

            init {
                println("Property 1 ${property1}") //We can access because of inner
                println("Property 2 ${property2}") //We can access because of inner
                println("Property 3 ${property3}")
            }

            fun foo3() {

            }
        }

        //Must have inner to access its outer property
        inner class ClassD {
            val property4: Int = 4

            //this. can't be accessed here
            fun foo4() {
                //now can access B because this is not nested inside C class
                this@ClassB.property2
            }
        }
    }
}

class ClassA1 {
    val property1: Int = 1

    class ClassB1 {
        val property2: Int = 2
        fun foo() {
            //this@ClassA.property1

        }

        //Error - must have inner
        class ClassC1 {
            val property3: Int = 3

            init {
                //println("Property 1 ${property1}") //We can access because of inner
                //println("Property 2 ${property2}") //We can access because of inner
                println("Property 3 ${property3}")
            }

            fun foo3() {

            }
        }

        //Must have inner to access its outer property
        inner class ClassD1 {
            val property4: Int = 4

            //this. can't be accessed here
            fun foo4() {
                //now can access B because this is not nested inside C class
                this@ClassB1.property2
            }
        }
    }
}

//Object declaration
object ObjA {
    val num: Int = 1
}

object ObjB {
    val num2: Int = 2
    fun test() {
        println("Obj B: without class keyword")
    }
}

//Singleton pattern using `object` keyword
object Singleton {
    private var instaLike = 0
    private var fbLike = 0

    fun incrementInstaLikes() = instaLike++
    fun incrementFbLikes() = fbLike++
    fun insights() = println("Insta like: ${instaLike}, Fb likes: ${fbLike}")

}

//Object expression - check main fn

//Use case: 1
//Implement interface without creating class
interface Cloneable {
    fun clone()
}

//Inherit without creating classes - Must be open
open class InheritWithoutClass {
    fun foo() {
        println("Class inherited without creating another class")
    }
}

class ObjectInsideClass {
    class AnotherClass {

    }
}

//difference between init & constructor
//init - called immediately
//constructor - called after init irrespective of order

//Difference between init & constructor
class Test {

    //Secondary constructor
    constructor() {
        println("Constructor called")
    }

    //Primary constructor - Called first irrespective of order
    init {
        println("Init called")
    }
}


//Companion object
//object declaration
object Value {
    val PI = 3.14
}

//companion object
class ValueCompanion {
    /*
    //can not access
    object Value {
          val PI = 3.14
      }
    */

    /*
    //will run - name is given
    companion object Value {
           val PI = 3.14
       }
     */

    //Recommended - name is not given
    companion object {
        val PI = 3.14
    }
}