package LearnKotlin.modules

import LearnKotlin.ClassA

fun main() {
    var dClass = BaseClass()
    //println(dClass.test ) //can not access test is protected
    println(dClass.test) //now we can access

    var test: BaseC = DerivedC()

}

internal open class BaseClass {
    internal open var test = 100
}
//class DerivedClass : BaseClass() {
//    //protected override var test = 100
//    //private override var test = 100 //incompatble
//    public override var test = 100
//}

/*protected class A {

}*/
class B {
    open var test = 10
}
//not public
/*fun B.foo() {

}*/

fun B.add() {
    test = 100
}

open class BaseC {
    var b = " "
}

class DerivedC : BaseC()  {
    var d = ""
    fun foo() {}
}

data class Bus(val name: String)

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

    fun printFormattedDate() {
        println("\nDay: $this")
    }
}
abstract sealed class ClassAA : BaseC() {
    //
}
class ClassBA : ClassAA() {
var test = 100
}
class y {
    class yy : x.testS() {

    }
}

class x {
    sealed class testS() {}
}
