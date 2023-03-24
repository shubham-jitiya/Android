package LearnKotlin.lambda

fun greet() {
    println("Hello, world")
}

fun main() {
    //The Unit return type cannot be omitted
    val onClickText: () -> Unit = {
        println("on text clicked!")
    }
    onClickText()

    //Type inference has `Unit` type
    val onClickButton = {
        println("on button clicked!")
    }
    onClickButton()


    //5. Nullable fun
    nullableFun()


    //7. Type alias
    val sum: sumAlias = { num1: Int, num2: Int ->
        val total = num1 + num2
        println(total)
    }
    sum(5, 2)


    //8. assign fun to a variable
    val assignFun = ::greet
    assignFun()

    //val assignFun2 = greet //Invalid
    //assignFun2()

    val greet2 = {
        print("Hello,  world")
    }
    val assignFun3 = greet2

    val treatAndTrickFun = trickOrTreat(true)
    treatAndTrickFun() //Have a cupcake!


    //9. omit parameter
    implicitIt()


    //repeat higher order
    homeWork()


    //trailing lambda
    trailingLambdas()


    //omit unused parameters
    omitUnusedParameters()


    //implicit return
    implicitReturn()

    anonymousFun()
}

//2. Receiver type
//3. Suspending fun
//4. Named fun
//5. nullable fun
fun nullableFun() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }
    val cupCake: (Int) -> String = {
        "Have a cupcake!"
    }

    //nullable higher order fun
    fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
        if (isTrick) {
            return trick
        } else {
            if (extraTreat != null)
                println(extraTreat(5)) //calling if not nul
            return treat
        }
    }

    trickOrTreat(false, null)
    trickOrTreat(false, cupCake)
    trickOrTreat(false, { "$it" }) //passing Lambda expression Directly - prints - 5
    trickOrTreat(false) { "$it" } //moved out: Trailing lambda expression - prints - 5
}


//6. with parenthesis
//fun - that returns lambda
//can we define nested fun? yes

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

val trick = {
    println("No treats!")
}
val treat = {
    println("Have a treat...")
}


//7. type alias
typealias sumAlias = (Int, Int) -> Unit


//9. implicit it
//omit the parameter name and  `->` symbol
fun implicitIt() {
    val total: (Int) -> Unit = {
        println("Number entered: $it")
    }
    total(100)
}


// Higher order fun - Repeat
fun homeWork() {
    val times = 5
    fun doHomeWorkXTimes(num: Int) {
        println("Doing homework $num time")
    }
    repeat(times) {
        doHomeWorkXTimes(it)
    }
}


//trailing lambdas
fun trailingLambdas() {
    val lambdaNumber: (Int) -> Unit = { println("Number: $it") }
    fun printNumber(sum: (Int) -> Unit) {
        sum(5)
    }

    //printNumber(lambdaNumber)
    //in curly braces we define what function does
    //printNumber({ println("Number: $it")})
    printNumber { println("Number: $it") } //omit () - if the lambda is the only argument in that call
    printNumber() { } //alternative way - trailing lambda
    println("Trailing")
}


//Underscore for unused variables
fun omitUnusedParameters() {
    val subjects: (String, String) -> Unit = { _, sub2 ->
        println("$sub2")
    }
    subjects("Physics", "Mathematics")
}


//return value implicit from lambda
fun implicitReturn() {
    //val sum: (Int, Int) -> Int = { num1, num2 -> num1 + num2}
    val sum: (Int, Int) -> Int = { num1, num2 ->
        print("$num1 + $num2 = ")
        num1 + num2
    }
    println(sum(5, 5))
}


//Anonymous fun
fun anonymousFun() {
    val test = fun(num1: Int, num2: Int): Int = num1 + num2
    println(test(5, 2))
}