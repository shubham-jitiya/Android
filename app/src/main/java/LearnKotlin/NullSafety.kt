package LearnKotlin

fun main() {
    //non null by default
    var name: String = "Shubham"
    var lastName = "Jitiya"
    //name = null //Invalid
    //lastName = null //by default non null


    //explicitly defining nullable variables
    var firstName: String? = "Shubham"
    //firstName = null


    //Access property
    //firstName.length //Invalid - use ?.


    //1. Checking for null in conditions
    if (firstName != null) {
        println("Contains length of: ${firstName.length}")
    } else {
        println("String is null")
    }
    //2. Safe calls - used for chain call eg. object that hold nullable property
    //Such a chain returns null if any of the properties in it is null
    println("Contains length of: ${firstName?.length}")

    //3. chain calling
    var nativeMobile = EmployeeData("Shubham")
    println(nativeMobile.head?.getManager()) //head is null so method is not called

    //nullable receiver with extension

    //4. give default value
    //1. with if else
    var middleName: String? = "Shubham"
    var userName: Int = if (middleName != null) middleName.length else 0
    //2. with elvis operator
    var uName: Int = middleName?.length ?: 0


    //5. not-null assertion operator (!!)
    //throw NPE if it found null
    var petName: String? = "PetName"
    petName = null
    //println(petName!!.length) //why not able to access

    //safe cast
    var luckyNumber: String? = "123"
    //println(luckyNumber as Int) //class cast exception
    println(luckyNumber as? Int) //returns null

    //with collections
    val fruits: MutableList<String?> = mutableListOf("mango", null, "banana")
    //val list can be modified
    fruits[1] = "kiwi" //not access if it is not of type MutableList
    println(fruits[1])

    //with let - with else condition
    var lName: String? = null
    var result = lName?.let { println(it) } ?: "It is null"
    println(result)

    //similar to if-let in swift. with run
    var nullableValue: String? = "Hello"
    //val nullableValue: String? = null
    val nValue = nullableValue?.let { value ->
        // Do something with non-null value
        "The value is $value"
    } ?: run {
        // Do something when nullableValue is null
        "The value is null"
    }
    println(nValue) //The value is Hello

   //run catching
   var fName: String? = null
   var testUser = fName?.let {
       "test user not null"
   } ?: kotlin.runCatching { "test user is null" }.also { println("next statement") }
    println(testUser) //Success(test user is null)
}

class EmployeeData(personName: String? = null, departmentName: String? = null) {
    var person: String? = personName
    var department: String? = departmentName
    var head: EmployeeData? = null

    fun getManager() {
        println("manager is busy right now, please wait for a moment.")
    }
}



