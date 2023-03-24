package LearnKotlin

import kotlin.Any
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {

    //1. Standard delegates
    println(lazyValue)

    //2.1 Observable properties
    var newUser = UserFb()
    newUser.name = "Shubham"

    //2.2 Vetoable properties
    val person = VetoableProperty()
    println(person.age) // Output: 0

    person.age = 25
    println(person.age) // Output: 25

    person.age = 18
    println(person.age) // Output: 25 (rejected change)

    person.age = 30
    println(person.age) // Output: 30


    //delegate properties
    var newStudent = ClassWithDelegate1(10)
    var student = MyClass(1, newStudent)
/*

    println("member: ${student.delegatedToMember}")
    student.delegatedToMember = 5
    println("member: ${student.delegatedToMember}")

*/
    println("top level: ${student.delegatedToTopLevel}")
    student.delegatedToTopLevel = 5
    println("top level: ${student.delegatedToTopLevel}")

    //delegate property to property
    val myClass = ClassWithDelegate()
    // Notification: 'oldName: Int' is deprecated.
    // Use 'newName' instead
    myClass.oldName = 42
    println(myClass.newName) // 42


    //storing properties in a map
    val newUsers = PremiumUsers(
        mapOf(
            "name" to "John doe", "age" to 25
        )
    )
    println(newUsers.map)

    //local delegated properties
    localDelegatedProperties()

    //Delegate requirements
    testDelegateByClass()
    testDelegateByInterface().also { println() }

    //provideDelegate
    testProvideDelegate()
}


//Standard delegates
val lazyValue: String by lazy {
    println("Computed")
    //return@lazy "Hello" //returns
    "Hello" //returns
}

//Observable properties
class UserFb() {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("Property: ${property.name} | changed from old value: $oldValue to $newValue")
    }
}

class VetoableProperty() {
    var age: Int by Delegates.vetoable(0) { _, oldAge, newAge ->
        newAge >= oldAge //allow update only if the new value is greater than or equal to the old value
        /*
        if (newAge >= oldAge) {
            println("trying to assign new age but it won't")
        }
        false  //This will veto - does not assign just checks
        */
    }
}


//Delegated to another property
var topLevelInt1: Int = 0

class ClassWithDelegate1(val anotherClassInt: Int)

class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate1) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt

//Delegating to another property
var topLevelInt = 0

class ClassWithDelegate() {
    var newName: Int = 0

    @Deprecated("Use 'newname' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}


//Storing properties in map
class PremiumUsers(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}


//Local delegated properties
fun localDelegatedProperties() {
    val lazyString: String by lazy {
        println("Computing string")
        "Hello, world!"
    }
    println("First call")
    println(lazyString) //Computing string, Hello, world!
    println("Second call")
    println(lazyString) //Hello, world!
}


//Property delegate requirements

//by implementing interfaces
class DelegateRequirements() : ReadWriteProperty<Int, Int> {
    override fun getValue(thisRef: Int, property: KProperty<*>): Int {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: Int, property: KProperty<*>, value: Int) {
        TODO("Not yet implemented")

    }
}

//by operator overloading
class DelegateByClass() {
    private val items = mutableMapOf<String, String>()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return items[property.name] ?: "Not available"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        items[property.name] = value
    }

    //How do I access it?
    fun getAllItems(): String {
        return items.values.toString()
    }
}

class Fruits() {
    var delegateByClass: String by DelegateByClass()
}

fun testDelegateByClass() {
    val fruit = Fruits()

    println(fruit.delegateByClass) //read
    fruit.delegateByClass = "Mango" //write
    println(fruit.delegateByClass)

    fruit.delegateByClass = "Banana"
    println(fruit.delegateByClass)
}

//Custom delegated property by implementing interfaces
class customDelegation() {
    var stringOne: String = ""
        set(value) {
            field = "${value.trim()} is a String"
        }
    var stringTwo: String = ""
        set(value) {
            field = "${value.trim()} is a String"
        }
    var stringThird: String = ""
        set(value) {
            field = "${value.trim()} is a String"
        }

    var stringN: String by TrimAppendDelegate()
}

//1.
class TrimAppendDelegate() : ReadWriteProperty<Any, String> {
    private var trimAppendedString = ""
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return trimAppendedString
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        trimAppendedString = "${value.trim()} is a String"
    }
}

fun testDelegateByInterface() {
    //custom delegation
    var testString = customDelegation()

    //using setters
    println(testString.stringOne)
    testString.stringOne = "Checking....   "
    println(testString.stringOne)

    //using custom delegation
    testString.stringN = "Converting...       "
    println(testString.stringN)
}


//provideDelegate
class ExampleProvideDelegate() {
    val lazyValue: String by lazy {
        println("Computing...")
        "Hello"
    }
    val customValue: String by CustomProvideDelegate() //calls provideDelegate()
}

class CustomProvideDelegate() : ReadOnlyProperty<ExampleProvideDelegate, String> {
    override fun getValue(thisRef: ExampleProvideDelegate, property: KProperty<*>): String {
        return "${property.name} is accessed"
    }

    //must have exactly 2 parameters
    operator fun provideDelegate(
        thisRef: ExampleProvideDelegate, prop: KProperty<*>
    ): ReadOnlyProperty<ExampleProvideDelegate, String> {
        println("Initialised ${prop.name} with custom delegate")
        return this
    }
}

fun testProvideDelegate() {
    val exampleProvideDelegate = ExampleProvideDelegate() //calls provideDelegate()
    println(exampleProvideDelegate.lazyValue) //Computing... \nHello
    println(exampleProvideDelegate.lazyValue) //Hello

    println(exampleProvideDelegate.customValue) //customValue is accessed
    println(exampleProvideDelegate.customValue) //customValue is accessed
}