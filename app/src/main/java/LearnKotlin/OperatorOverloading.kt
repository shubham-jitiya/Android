package LearnKotlin

fun main() {
    //Unary minus
    val point = Point(10, 20)
    println(-point) //Point(x = -10, y = -20)

    var num = MyNumber(100)
    println(num.value) //100
    --num //operator overloaded or else not possible
    println(num.value) //99

    //Binary operation
    var counter = Counter(1)
    val incrementedDays = counter + 5
    println(counter.dayIndex)
    println(incrementedDays)
}

data class Point(val x: Int, val y: Int)

//Unary minus
operator fun Point.unaryMinus() = Point(-x, -y)

//Inc & dec
class MyNumber(var value: Int) {
    //overload operator
    operator fun dec(): MyNumber {
        --value
        return this
    }
}

//Binary operation
class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }

    override fun toString(): String {
        return "$dayIndex"
    }
}
