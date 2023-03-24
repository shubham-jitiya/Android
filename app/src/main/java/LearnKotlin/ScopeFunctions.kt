package LearnKotlin

import LearnKotlin.collection.Students
import java.util.*

//let run with apple also
fun main() {
    val classPhysics = listOf<Students>(
        Students("Jitiya", "Shubham", "CE", 21),
        Students("Trivedi", "Bhakti", "CE", 23),
        Students("Sartanpara", "Shyam", "EE", 20),
        Students("Vyas", "Divyesh", "BME", 20),
        Students("Nagpurkar", "Manthan", "EC", 16)
    )
    //let - can be used to check nullability
    var letVariable = Students("Jitiya", "Shubham", "CE", 21).let {
        //currentPerson -> //Valid with `it` only
        //it.firstName + it.lastName
        //it
        //println("Hello")
        //return@let "${it.firstName} ${it.age}"
    }
    println("1. $letVariable")
    //run
    var runVariable = Students("Jitiya", "Shubham", "CE", 21).run {
        //currentPerson -> //Invalid with `this` only valid in `it`
        //this.firstName + this.lastName
        //this
        return@run "${this.firstName} ${this.age}"
    }
    println("2. $runVariable")
    //with
    var withVariable = with(Students("Jitiya", "Shubham", "CE", 21)) {
        //this.firstName + this.lastName
        //this
        return@with "${this.firstName} ${this.age}"
    }
    println("3. $withVariable")

    //custom apply
    fun Int.apply(fn: Int.() -> Int) : Int {
        //val sum = this
        //this.fn()
        return this.fn()
    }

    val num = 5
    println("Sum: " + num.apply { this + 1 })

    //apply - can not return result
    var applyVariable = Students("Jitiya", "Shubham", "CE", 21).apply {
        //this.firstName + this.lastName
        //return@apply "" //invalid - can't return anything
        return@apply //valid - but by default it returns object
    }
    println("4. $applyVariable")

    //also - can not return result
    var alsoVariable = Students("Jitiya", "Shubham", "CE", 21).also {
        //currentPerson -> //Valid with `it` only
        //it.firstName + it.lastName
        //return@also "" //can't return anything other than object
        return@also //valid - but by default it returns object
    }
    println("5. $alsoVariable")

    //takeIf and takeUnless
}