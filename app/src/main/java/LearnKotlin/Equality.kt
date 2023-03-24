package LearnKotlin

fun main() {
    var name = "Shubham"
    var firstName = name
    //var firstName = name + " "
    println("Structural equality: ${name == firstName}")
    println("Referential equality: ${name === firstName}")

    var myCart = arrayListOf<String>("Apple", "Mango", "Banana")
    var groceryCart = arrayListOf<String>("Apple", "Mango", "Banana")
    var friendsCart = arrayListOf<String>("Banana", "Apple", "Mango")
    println("Structural equality: ${myCart == friendsCart}") //false
    println("Structural equality: ${myCart == groceryCart}") //true

    println("Referential equality: ${myCart === groceryCart}") //false
    //println("Structural equality: ${myCart.equals(friendsCart)}") //false
    println("Referential equality: ${myCart === friendsCart}") //false

    var fruitsCart = groceryCart
    println("Referential equality: ${fruitsCart === groceryCart}") //true
}