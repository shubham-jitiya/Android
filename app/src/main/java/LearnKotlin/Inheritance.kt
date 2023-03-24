package LearnKotlin

fun main() {

    //1. Inheritance basics
    val nokia110 = Phone(103456789123456) //starting from 0 is not double or int
    println(nokia110.IMEI)
    nokia110.dialNumber("0123456789")

    val vivo = SmartPhone(113456789012345)
    println(vivo.IMEI)
    vivo.takePhoto()

    val samsungFoldable = FoldablePhone(223456789012345)
    println(samsungFoldable.IMEI)
    samsungFoldable.closePhone()

    val newTruck = Truck()


    //2. Overriding
    val newMobile = Mobile()
    println("New mobile Ram: ${newMobile.ram}")
    println("New mobile Size: ${newMobile.size}")
    newMobile.takePhoto()

    val newOneplus = Oneplus()
    println("\nOneplus Ram: ${newOneplus.ram}") //overrided property, `16`
    println("Oneplus Size: ${newOneplus.size}")
    newOneplus.takePhoto() //overrided method, `from oneplus, ...`


    //3. Calling parametrised constructor
    val vivoBase = Vivo("Base variant")
    println("\nModel: ${vivoBase.model}")
    println("Vivo Ram: ${vivoBase.ram}")
    vivoBase.takePhoto()

    val vivoU20 = VivoU20("Base variant")
    println("\nModel: ${vivoU20.model}")
    println("Vivo U20 Ram: ${vivoU20.ram}")
    vivoU20.takePhoto()


    //4. override getter & setter


    //5. Any
    val anyClass = Any()
    println(anyClass) //overriding default hash value of reference


    //Polymorphism - parent can hold reference to its child & call methods of child class
    //val vivoU21: VivoU20 = VivoU20("Base variant")
    val vivoU21: Vivo = VivoU20("Base variant") //Achieved polymorphism
    println(vivoU21.model)
    //vivoU21.newFeatures() //Can only call common methods!!

}

//can not inherit
class IsFinalDefault {

}

//can inherit
open class IsFinalDefault2 {

}

//by default all classes are final, can't be inherited (use open)
/*
class CanInherit: IsFinalDefault {}
*/



/*
    1. Inheritance basics
        - is a relationship

        eg. Car is a vehicle, Truck is a vehicle
            Square is a shape, circle is a shape
            Cat is a animal, dog is a animal
            Saving account, current account
            Full time employee, part time employee
*/
open class Phone(val IMEI: Long) {
    fun dialNumber(phoneNumber: String) {
        println("Calling to ... $phoneNumber")
    }
}

class SmartPhone(IMEI: Long) : Phone(IMEI) {
    fun takePhoto() {
        println("Photo clicked, saving please wait ...")
    }
}

class FoldablePhone(IMEI: Long) : Phone(IMEI) {
    fun closePhone() {
        println("Folding phone ...")
    }
}

//2. if parent & child both have init then first init of parent is called first, same for constructor
// because child can’t exist without parent.
open class Vehicle {
    init {
        println("Parent: Init of vehicle is called")
    }

    constructor() {
        println("Parent constructor")
    }
}

/*
//Invalid: Supertype initialization is impossible without primary constructor
class Truck : Vehicle() {
    init {
        println("Child: Init of truck is called")
    }

    constructor() {

        println("Child constructor")
    }
}
*/
class Truck : Vehicle {
    init {
        println("Child: Init of truck is called")
    }

    constructor() {

        println("Child constructor")
    }
}


//2. Overriding - open
open class Mobile() {
    val size = 5
    open val ram = 2

    fun dialNumber(phoneNumber: String) {
        println("Calling from mobile ... $phoneNumber")
    }

    open fun takePhoto() {
        println("Photo clicked, saving please wait ...")
    }
}

class Oneplus : Mobile() {
    //override val size = 6 //We can not override this property, because it is not open in parent
    override val ram = 16 //Must write override

    override fun takePhoto() {
        super.takePhoto() //first calls method of parent then calls overrided method of child
        println("Photo clicked from oneplus, saving please wait ...")
    }
}

//3. parametrised constructor
open class Vivo(val model: String) {
    val ram = 16

    open fun takePhoto() {
        println("Photo clicked from vivo, saving please wait ...")
    }
}

open class VivoU20(model: String) : Vivo(model) {

    override fun takePhoto() {
        println("Photo clicked from vivo U20 50mp, saving please wait ...")
    }

    fun newFeatures() {
        println("New feaures of vivo U20")
    }
}

//4. Any - Every classes has super class “Any”
class Any {
    val price: Int = 0
    val name: String = ""
    override fun toString(): String {
        return "${name} & ${price}"
    }
}

