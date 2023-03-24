package LearnKotlin.modules

import LearnKotlin.test

fun main() {
   /* var dClass = Login()
    //println(dClass.test ) //can not access test is protected
    println(dClass.test ) //now we can access*/
    var testMap = HashMap<Testing, Int>()
    testMap.put(Testing.TestA(1), 1)
    testMap.put(Testing.TestA(1), 3)
    println(testMap)
    println(Testing.TestA(1) === Testing.TestA(1))

/*    var test1 = Testing.TestA(1)
    println(test1.hashCode())
    var test2 = Testing.TestA(1)
    println(test2.hashCode())
    println(test1 === test2)*/
//    println(test1.equals(test2)) // same as `==`

}
/*
class Login : BaseClass() {
    //protected override var test = 100
    //private override var test = 100 //incompatble
    public override var test = 100
}
*/
class ClassBCC : ClassAA() {

}
sealed class Testing() {
    data class TestA(val testOne: Int) : Testing()
    class TestB() : Testing()
}