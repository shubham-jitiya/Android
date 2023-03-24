package LearnKotlin

fun main() {

    //How behind the scene labdas work?
    //It create class & then instance of it which leads to performance hit as more memory is being used
    //calculateExecutionTime { loop(10000000000) }

    //Example with local return - SKIP For NOW
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter {
        if (it % 2 != 0) return@filter false
        println("Processing $it")
        true
    }

    println("Even numbers: $evenNumbers")

    nonLocalReturns()
}

//Remove inline & see the `bytecode`
inline fun calculateExecutionTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("Time taken: ${end - start} ms")
}

fun loop(n: Long) {
    for (i in 1..n) {

    }
}

//if we don’t want our all labdas to be inline we can use `noinline`
inline fun calc(noinline add: () -> Void, subtract: () -> Unit) {

}

//bare return
fun foo() {

}

//cross inline modifier - only for inline fun
inline fun processNumber(list: List<Int>, crossinline option: (Int) -> Unit) {
    list.forEach { number ->
        // Execute the lambda without allowing non-local returns
        option(number)
    }
}


//non-local returns
fun nonLocalReturns() {
    val numbers = listOf(1, 2, 3, 4, 5)

    numbers.forEach myLoop@{
        if (it == 3) return@myLoop
        println(it)
    }

    println("Done with loop")
}

//prerequisites: Generics