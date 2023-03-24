package LearnKotlin

fun main() {

    //Basic
    val dayOne = Days.MONDAY
    println(dayOne)

    //access values associated with enums
    println(dayOne.at)

    //Traverse
    for (i in Days.values()) {
        print("${i}, ") //MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY,
    }

    //Method
    dayOne.printFormattedDate() //Day: MONDAY

    val test = Days.TestOne()
    test.test() //Working

    //can we inherit sealed class in another module? No

    //Can do - inherit subclasses of sealed class
    class Dog : Animal.Mammal()
    class JapaneseCat : Animal.Mammal()

    //Can access properties of subclass of sealed class
    var newDog = Dog()
    newDog.name

    //Can not inherit sealed class
    //type is sealed, so it can be inherited by only its own nested classes or objects
    //class Reptile() : Animal()
    //class newShapeCircle() : Shape()
}

//Define enum class - for set constant values
enum class Days(val at: Int) {
    //functions can not be defined here

    //INSTANCES
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6);

    //Class in enum
    class TestOne() {
        fun test() {
            println("working ..")
        }
    }

    //Method
    fun printFormattedDate() {
        println("\nDay: $this")
    }
}