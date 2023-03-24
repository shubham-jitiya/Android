package LearnKotlin

fun main() {
    //var teacher = PersonInterface()///Invalid: We can not create instance of interface
    var teacher = IndianTeacher()
    println(teacher.name)
    teacher.run()
    teacher.teach()

    //Implementing multiple interfaces
    var foreignTeacher = ForeignTeacher()
    println()
    foreignTeacher.teach()
}

//All properties are by default abstract and open & must not be initialised
interface TeacherInterface {
    //var name: String = "" //Invalid: Can not be initialised
    //abstract open var name: String //Warning: Redundant - abstract & open. It is by default
    //final var age: Int //Invalid: final is not applicable
    //abstract fun run() {} //Invalid: can not be abstract with body. Remove body or abstract. must be implemented in subclasses or make subclass as abstract
    //We can not create instance of interface

    var name: String
    abstract fun run() //Warning: Redundant abstract

    //Default implementation is provided so in subclasses/implementing class it is optional to implement
    fun teach() {
        println("Teacher: Teaching in proxy period")
    }
}

//Implement interface
class IndianTeacher : TeacherInterface {
    override var name: String = "Shubham"
    override fun run() {
        println("Teacher is running")
    }

    override fun teach() {
        super.teach() //calls method of super class/interface first (optional)
        println("Teaching science")
    }

    fun takeTest() {}
}


//What if I implement multiple interfaces & both interfaces may have some common methods?
interface ProfessorInterface {
    var name: String

    //Default implementation is provided so in subclasses/implementing class it is optional to implement
    fun teach() {
        println("Professor: Teaching in proxy period")
    }

    fun takeTest() {
        println("Foreign teacher is taking test")
    }
}

//Implement multiple interfaces
//Implement interface
class ForeignTeacher : TeacherInterface, ProfessorInterface {
    override var name: String = "Shubham"
    override fun run() {
        TODO("Not yet implemented")
    }

    //We have two methods with same name in both the interfaces with body
    //(MUST) implementing methods from either of them is the same thing
    // Tip: option + enter to see teach() method from both interfaces

    /*
        override fun teach() {
            TODO("Not yet implemented")
        }
    */

    override fun teach() {
        //if exist multiple interface/class with same common method,
        //specify which super class/interface we want to call using `< >`
        super<ProfessorInterface>.teach()
        super<TeacherInterface>.teach()

        //Do we need to provide `< >` everytime? No,
        //if out of both interface any one has body but another don't have. Then method with body is called
        super.takeTest() //As it has only one implementation no need to specify which interface using `< >`

        println("Foreign teacher is teaching")
    }
}