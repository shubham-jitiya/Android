package LearnKotlin

fun main() {

    //Getters & setters
    val shubham = Person6(nameParam = "Shubham", 22)
    shubham.age = -8
    println(shubham.name)

    //getter with val
    val rectangle1 = Rectangle1(10, 20)
    println("Area: ${rectangle1.area}")

    val rectangle2 = Rectangle2(5, 10)
    println("Area: ${rectangle1.area}")


    //Backing field
    val newPerson = Human()
    newPerson.age

    //Backing property
    val backingProperty = BackingProperty()
    backingProperty.name = "Shubham"
    println(backingProperty.name)

}

//Getters & setters
class Person6(nameParam: String, ageParam: Int) {
    var name = nameParam
        get() {
            println("\nName getter is called")
            return field.uppercase() //Field not name
        }
    var age = ageParam
        set(value) { //by default it is value but we can change
            println("Setter is called")
            if (value > 0) {
                field = value
            } else {
                println("Age can't be negative!")
            }
        }
}

class Rectangle1(val width: Int, val height: Int) {
    val area: Int  // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height //if not given getter then the above line will be giving error for initializer
    //val can not have setter
}

//omit property type - infer from getter
class Rectangle2(val width: Int, val height: Int) {
    //val area: Int  // property type is optional since it can be inferred from the getter's return type
    val area get() = this.width * this.height //This can not be var
}

//Backing field
class Human {
    var age = 20
        get() {
            //println(age) // this will cause infinite stack overflow exception
            println("Age is: $field") // use field to fix it
            return field
        }
        set(value) {
            field = value
            //age = value //stack overflow exception
        }

    //backing fields won't be generated
    var name: String = ""
    var isOld: Boolean = false
        get() = age >= 50
}

//Backing property
class BackingProperty {
    private var _name: String = ""
    public var name: String
        get() {
            return _name
        }
        set(value) {
            _name = value
        }

    //Inside the class always use _ fields
    //Outside the class always use fields without underscore
}

//lateinit
/*
lateinit var test: Int //Invalid
lateinit var test: Float //Invalid
lateinit var test: Integer //Valid
lateinit var test: String //Valid*/
