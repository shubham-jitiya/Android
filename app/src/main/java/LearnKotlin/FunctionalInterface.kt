package LearnKotlin

fun main() {
    //without SAM (Single abstract method using object)
    test(4, object : IntPredicate {
        override fun check(i: Int): Boolean {
            return i % 2 == 0
        }
    })

    //With SAM
    test(4) { i -> i % 2 == 0 } //This won't work if IntPredicate is not functional interface

    //can also assign to variable
    val checkNum = IntPredicate { it % 2 == 0 }
    test(4, checkNum).also { println() }


    //3. Invoke operator -
    val checkNum2 = IntPredicate2 { it % 2 == 0 }
    test2(4, checkNum2)


    //4. Return functional interface - must know lambda
    val timesX = MathFormula { times ->
        { it * times }
    }
    val timesTwo = timesX.value(2)
    val timesThree = timesX.value(3)
    println(timesTwo(10))


    //5.fn that takes function interface & function
    val task = Task("Complete functional interface")
    runBlock1(task) {
        println("Running: ${it.name}")
    }
    runBlock2(task) {
        println("Running: ${task.name}")
    }


    //6. with type aliases
}

//Have exactly 1 abstract method & n non abstract method
//@FunctionalInterface ??
fun interface PhoneInterface {
    fun takeAPhoto() //abstract
//    abstract fun makeACall() //Invalid: can have only 1 abstract method

    //can have n non abstract method
    fun makeACall() {
        println("Calling...")
    }
}


//Ex.1
fun interface IntPredicate {
    fun check(i: Int): Boolean
}

fun test(num: Int, predicate: IntPredicate) {
    if (predicate.check(num)) {
        println("Valid")
    } else {
        println("Invalid")
    }
}

//Ex.3 invoke operator
fun interface IntPredicate2 {
    operator fun invoke(i: Int): Boolean //operator & invoke
}

fun test2(num: Int, predicate: IntPredicate2) {
    //we can call directly
    if (predicate(num)) {
        println("Valid")
    } else {
        println("Invalid")
    }
}

/*
    Ex.4 we can return functions from functional interfaces,
    eg. (Int) -> (Int) -> Int
*/
fun interface MathFormula {
    fun value(num: Int): (Int) -> Int
}

/*
   //5.fn that takes functional interface & function
*/
data class Task(val name: String)

fun interface Executor {
    fun run(task: Task)
}

//takes functional interface
fun runBlock1(task: Task, executor: Executor) {
    executor.run(task)
}

//takes function
fun runBlock2(task: Task, block: (Task) -> Unit) {
    block(task)
}
