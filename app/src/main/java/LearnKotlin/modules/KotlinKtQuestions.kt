package LearnKotlin.modules

import LearnKotlin.test

private fun testLazy(): String {
    println("Computing")
    return "Shubham"
}

fun main() {

    //Can we make companion object in class
    TestCompanionObject.foo()

    //is else mandatatory in `when` if using without expression - No
    var randomNumber = 5
    when (randomNumber) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        //5 -> println("Five")
    }

    //nothing

    try {
        // var num: Nothing = returnsNothing()
        var num: Int = returnsNothing()
        returnsNothing()
    } catch (e: RuntimeException) {
        println(e)
    }

    //member variables as default value
    DefaultValue().calc()

    //Check if lateinit is initialized or not
    //only work inside class
    var testLateInit = LateInit()
    //testLateInit = "Shubham" //runtime exception : Type mismatch
    println("Initialised ?: ${testLateInit.isInitialised()}")

    //var: Invalid - may work by providing extension
/*    private var name: String by lazy {
        testLazy()
    }*/


    //loop in float - ?
    var myRange = 0.5f
    for (i in 1..5) {

    }

    //run pseudo codes
    //1.
    var a: A? = null

    //executed only if it is not null
    a?.let {
        println(it.a)
    }
    //executed even if it is not null
    a.let { println(it?.a) }


    //2. different declarations
    val testObj1 = A1(10)
    testObj1.foo() //10
    val testObj2 = C1(10)
    testObj2.foo() //10


    //3. Checking data class values
    val testDataClassA = A2(11)
    testDataClassA.b = 30

    val testDataClassB = A2(11)
    testDataClassB.b = 40

    println("$testDataClassA ${testDataClassA.b} \n$testDataClassB ${testDataClassB.b} \nisEqual : ${testDataClassA == testDataClassB}") //true
    println("$testDataClassA ${testDataClassA.b} \n$testDataClassB ${testDataClassB.b} \nisEqual : ${testDataClassA === testDataClassB}") //true

    //val

    //anonymous object
    var student = object {
        fun foo() {
            println("Foo called")
        }
    }
    student.foo();

    //property overring
    var propertyOverriding = PropertyOverriding()
    println(propertyOverriding.score)

    var tc = TC()
    TC.foo()
    
}

open class TestCompanionObject {
    companion object FOO {
        fun foo() {
            println("Companion object called")
        }
    }
}
class TC: TestCompanionObject() {
    companion object FOO {
        fun foo() {
            println("overrided object called")
        }
    }
}

object AX {
    object FOO {
        fun foo() {
            println("AX object called")
        }
    }
}

fun returnsNothing(): Nothing {
    println("Nothing function executed")
    throw RuntimeException()
}

class DefaultValue() {
    val PI = 3.14
    private var testPrivate = 100
    protected var testProtected = 100
    fun calc(pi: Double = PI) {
        println("Value of PI: $PI")
    }
}

private fun DefaultValue.testPrivateExtension() {
    val marks = ""
    //println("$testPrivate") //not accessible
    //println("$testProtected") //not accessible
}

class LateInit() {
    lateinit var name: String

    //name = "Shubham" //can not assign
    fun isInitialised(): Boolean {
        //name = "Shubham" //initialised but can not access directly with instance and assign it or in member scope
        return ::name.isInitialized
    }
}

//initialiser in interface
interface RaceCourt {
    /* init {

     }*/
}

//Run pseudo programs
class A {
    var a = 10
}

//Difference between different declaration
//a: member variable
class A1(val a: Int) {
    fun foo() {
        println(a)
    }
}

//a: parameter
class B1(a: Int) {
    fun foo() {
        //println(a) //Invalid
    }
}

//a: giving visibility modifier
class C1(private val a: Int) {
    fun foo() {
        println(a)
    }
}
//class D1(private a: Int) //Invalid

//checking data class values
data class A2(val a: Int) {
    var b = 10
}

fun Int.add() {

}
public abstract sealed class aa{}

//Property overriding
open class Property {
    open var score: Int = 100
}
interface PropertyInterface {
    var points: Int
    var score: Int
        get() = 10
        set(value) {
            points = value
        }
}
class PropertyOverriding : Property() {
    override var score: Int = 10
}

