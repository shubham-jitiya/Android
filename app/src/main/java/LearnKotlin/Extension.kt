package LearnKotlin

fun main() {

    //1. Simple example
    var shubham = Student()
    //shubham.hasPassed(41)
    println("Is passed: ${shubham.hasPassed(41)}")
    println("Scholarship status: ${shubham.isScholar(99)}") //true

    //2. Usecase: Create extension of String that can add two string
    val msg1 = "Message one"
    val msg2 = "Message two"
    val msg3 = "Message three"

    println(msg1.add(msg2, msg3))

    //3. Create extension to find greater number
    val marksOne = 20
    val marksTwo = 25
    println(marksOne.findGreater(marksTwo)) //Replaced with `this`

    //4. Extension with interfaces
    val newJoinee = Trainee("Shubham")
    newJoinee.getInfo() //Name of trainee: Shubham
    newJoinee.getEmployeeDetails() //extension is called

    //5. Extension as member function
    val tataPunch = Tata(Radio("98.5"), "Tata punch")
    tataPunch.showCarDetails() //Tata punch : Playing at frequency 98.5

    //6. Extension of property
    val extensionProperty = MyClass1()
    println(extensionProperty.myProperty)
    println(extensionProperty.myExtendedProperty)

}


//1. Assume that below class is already written by some x developer & we want to add new fun to it without writing inside it
class Student {
    fun hasPassed(marks: Int): Boolean {
        return marks > 40
    }
}

//Add this fun inside class Student without writing inside it
//Class must be public
fun Student.isScholar(marks: Int): Boolean {
    return marks > 95
}


//2. String extension
fun String.add(str1: String, str2: String): String {
    return "$this - $str1 - $str2"
}


//3. Create extension to find greater number
fun Int.findGreater(num2: Int): String {
    if (this > num2) {
        return "Num1 : ${this} is greater"
    } else {
        return "Num2 : ${num2} is greater"
    }
}


//4. Extensions with interfaces
interface Employee {
    val name: String
    fun getInfo()
}

//extension - methods with same name in interfaces are never called. Overrided methods from classes is called
fun Employee.getEmployeeDetails() {
    print("Employee: $name")
}

class Trainee(override val name: String) : Employee {
    override fun getInfo() {
        println("Name of trainee: ${name}")
    }
}


//5. Extension as member function
//Dispatcher: Tata class
//Receiver: Radio class

class Radio(val frequency: String) {
    fun play() {
        println("Playing at frequency ${frequency}")
    }
}

class Tata(val radio: Radio, val carName: String) {
    fun printName() {
        print("\n${carName}")
    }

    //extension as member
    fun Radio.audioDetails() {
        printName()
        print(" : ")
        radio.play()
    }

    fun showCarDetails() {
        radio.audioDetails()
    }
}


//extension of properties
class MyClass1 {
    var myProperty: String = "Hello"
}

val MyClass1.myExtendedProperty: Int
get() = myProperty.length
