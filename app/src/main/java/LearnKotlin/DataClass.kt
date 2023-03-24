package LearnKotlin

fun main() {
    //Check equality of two objects
    val user1 = User("Shubham", 100)
    val user2 = User("Shubham", 100)
    //Object is created inside heap at two different memory location & we are checking are they both have same memory location?
    println("Is equal: ${user1 == user2}")
    println("Is equal: ${user1.equals(user2)}") //same as above

    println(user1) //User@34ce8af7
    println(user2) //User@b684286

    //Copy method
    val user3 = user1.copy() //we got from data class
    println(user3 == user1)
    println(user3)

    val user4 = user1.copy("Tirth") //we got from data class
    println(user4) //User(name=Tirth, id=100)

    val user5 = user1.copy(id = 81) //copy using named parameters
    println(user5)//User(name=Shubham, id=81)

    //inner class with data class
    val person = Tourist("John Doe", 30)
    val address = person.Address("123 Main St.", "Anytown")
    println(person)
    println(address.city)
    println(address.street)


}

//class User(val name: String, val id: Int) { } //on checking equality of references returns false
data class User(val name: String, val id: Int) {} //on checking equality of references returns true

//Invalid data class - must have val or var
//data class UserInsta(name: String, instaId: String)

data class People(val name: String)
//data class Community(val name: String) : People() //can not be inherited
//class Community() : People() //normal class can also not able to inherit as data class is final

//Inner class with data class
data class Tourist(var name: String, val age: Int) {
    inner class Address(val street: String, val city: String) {
        val n = name
    }
}

fun Tourist.getInfo() {}