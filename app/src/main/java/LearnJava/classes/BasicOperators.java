package LearnJava.classes;

public class BasicOperators {
    public static void main(String[] args) {

        System.out.println(5 + 2);
        System.out.println(5 * 2);
        System.out.println(5 / 2);
        System.out.println(5 % 2);

        int num1 = 5;
        System.out.println("Post Increment: " + num1++);
        System.out.println("Increment: " + num1);

        System.out.println("Pre Increment: " + ++num1);
        System.out.println("Increment: " + num1);

        System.out.println( 1 == 1);
        System.out.println( 1 == Integer.parseInt("1"));

        System.out.println( 5 > 2);
        System.out.println( 5 < 1);
    }
}
