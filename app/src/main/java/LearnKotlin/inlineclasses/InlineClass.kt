package LearnKotlin

fun main() {
    val num: int = 100
    val carpet = Rectangle(50L, 100L)
    carpet.getDetails()

    val width: Width = Width(50)
    val height: Height = Height(100)
    val cupboard = InlineRectangle(width, height)
    cupboard.getDetails()

    //Members
    val myFriend = Name("Shubham")
    //val myFriend = Name("S") //illegal argument exception
    println(myFriend.length)

    //Interface
    val juneTest = MakeTestPaper("Physics")
    juneTest.a4Document()

    //Representation
    val f = Foo(42)
    asInline(f) // unboxed: used as Foo itself?

    //delegation
    val my = MyInterfaceWrapper(object : MyInterface{
        override fun bar() {
            println("Bar called")
        }
    })
    println(my.foo())
    my.bar()
}

//Without inline class
class Rectangle(width: Long, height: Long) {
    //Issue is here I can interchange value and it doesn't give me compile time error!!
    private val width = height //expected 50
    private val height = width //expected 100

    fun getDetails() {
        println("width: ${this.width}, height: ${this.height}")
    }
}

//With inline class - to prevent the above issue
//I can create separate class for width & height which is inline

//if class is normal then it will no more be wrapper, it will print object - to check print hashcode
//inline is deprecated
@JvmInline
value class Height(val height: Long)

@JvmInline
value class Width(val width: Long)

class InlineRectangle(width: Width, height: Height) {

    /*
    //Now the below code will give compiler time error - in case if it found incorrect type given
    private val width: Width = height
    private val height: Height = width
    */
    private val width: Width = width
    private val height: Height = height

    fun getDetails() {
        //remove inline and check the value
        println("width: ${this.width.hashCode()}, height: ${this.height.hashCode()}")
    }
}
//inline Not applicable to local
/*
fun inlineClass() {
    @JvmInline //inline is deprecated
    value class Height(val height: Long)
    @JvmInline
    value class Width(val width: Long)
}
*/


//Members
@JvmInline
value class Name(val name: String) {
    init {
        require(name.length > 2) { } //Caution: illegal argument exception
    }

    //val lastName: String = "" //Invalid: No backing fields
    val length: Int
        get() = name.length

    fun greet() {
        println("Hello, $name")
    }
}


//Inheritance
interface Printable {
    fun a4Document()
}

@JvmInline
value class MakeTestPaper(val subject: String) : Printable {
    override fun a4Document() {
        println("Printing test paper ...")
    }
}

//Inline class can not extend any other class
/*
open class PhysicsPaper() {}
@JvmInline
inline class CreatePaper(val marks: Int) : PhysicsPaper() {}
*/


//Representation
@JvmInline
value class Foo(val i: Int)

fun asInline(f: Foo) {}

//Mangling
@JvmInline
value class UserId(val value: Int) {

    fun getUserId() {
        println("user id: $value")
    }
}

@JvmInline
value class OrderId(val value: Int)

data class Order(val userId: UserId, val orderId: OrderId) {
    //JvmName annotation: calling fun that takes inline class from java
    val uID = userId
    val oID = orderId
    @JvmName("getId")
    fun callInlineFun() {
        println(uID)
    }
}


//delegate inline class
interface MyInterface {
    fun bar()
    fun foo() = "foo"
}

@JvmInline
value class MyInterfaceWrapper(val myInterface: MyInterface): MyInterface by myInterface

