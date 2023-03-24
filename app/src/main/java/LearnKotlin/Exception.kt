package LearnKotlin

fun main() {
    divide(1, 0)
}

//we do not use throws
fun divide(a: Int, b: Int): Int {
    if (b == 0) {
        throw ArithmeticException("Division by zero")
    }
    return a / b
}
/* //Java
public int divide(int a, int b) throws ArithmeticException {
    if (b == 0) {
        throw new ArithmeticException("Division by zero");
    }
    return a / b;
}*/
