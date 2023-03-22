package LearnJava.classes;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

public class ErrorHandling {
    public static void main(String[] args) {

        //Exception types:
        //Arithmetic Exception
        int result = 50 / 0;
        System.out.println("This line will not be executed");

        //Null pointer exception
        String name = null;
        System.out.println(name.length());

        //Number format exception
        String firstName = "Shubham";
        int num = Integer.parseInt(firstName);

        //Array index out of bound exception
        int[] marks = new int[5];
        marks[10] = 100;
    }
}

//2. Handling exception with try-catch
class TryCatch {
    public static void main(String[] args) {
        //withOutTryCatch();
        //withTryCatch();
        //withParentException();
        //withCustomMessage();
        //withResolve();
        //withDifferentException();
        withAOBException();
    }

    //Ex. 1 not handling exception
    static void withOutTryCatch() {
        int data = 50 / 0;
        System.out.println("Line below without try catch ....");
    }

    //Ex. 2 Avoid writing code below exception throwing statement
    static void withTryCatch() {
        try {
            int data = 50 / 0;
            System.out.println("Line below exception throwing statement ....");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        System.out.println("Program execution continues...");
    }

    //Ex. 3 Recommended: Must handle specific, from most to least
    static void withParentException() {
        try {
            int data = 50 / 0;
            System.out.println("Line below exception throwing statement ....");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Program execution continues...");
    }

    //Ex. 4 Print custom message
    static void withCustomMessage() {
        try {
            int data = 50 / 0;
            System.out.println("Line below exception throwing statement ....");
        } catch (Exception e) {
            System.out.println("You can not divide by zero");
        }
        System.out.println("Program execution continues...");
    }

    //Ex. 5 Resolve exception
    static void withResolve() {
        int num1 = 10, num2 = 0;
        try {
            int data = num1 / num2;
            System.out.println("Line below exception throwing statement ....");
        } catch (ArithmeticException e) {
            int data = num1 / (num2 + 1); //This can also throw exception
            System.out.println("Resolved: " + data);
        }
        System.out.println("Program execution continues...");
    }

    //Ex. 6 Handled with different exception doesn't catches exception
    static void withDifferentException() {
        int num1 = 10, num2 = 0;
        try {
            int data = num1 / num2;
            System.out.println("Line below exception throwing statement ....");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("Program execution continues...");
    }

    //Ex. 7 Another unchecked exception
    static void withAOBException() {
        try {
            int[] marks = new int[5];
            marks[10] = 100;
            System.out.println("Line below exception throwing statement ....");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("Program execution continues...");
    }
}

//3. Multiple catch exception - must be from most specific to general
class MultipleCatch {
    public static void main(String[] args) {
        //multipleCatch();
        //catchException();
        catchUndefinedException();
    }

    //1. Handle with multiple catch - it finds automatically which catch block to execute
    static void multipleCatch() {
        try {
            int[] marks = new int[5];
            marks[10] = 50 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //2. At a time only one exception can be catch
    static void catchException() {
        try {
            int[] marks = new int[5];
            int num = 50 / 0; //1. Arithmetic exception
            System.out.println(marks[10]); //2. Array out of bound exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //3. If no matching exception found - it will be catch by parent Exception
    static void catchUndefinedException() {
        try {
            String name = null;
            name.length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (Exception e) { //Handled by this
            System.out.println(e);
        }
    }

    //4. No Order is maintained
    static void noOrder() {
        try {
            String name = null;
            name.length();
        } catch (Exception e) {
            System.out.println(e);
        }
        //compile time error
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        } catch (ArithmeticException e) {
//            System.out.println(e);
//        }
    }
}

//4. Nested try block - control flow
class NestedTryCatch {
    public static void main(String[] args) {
        //moreThanOnceException();
        nestedTryCatch();
        //nestedTryCatch2();

    }

    //1. Catch two different exception - if one try fails then it won't check try's present inside it
    static void moreThanOnceException() {
        try {
            String firstName = null;
            firstName.length();
            try {
                int num = 50 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    //2. If nested try catch can't find its catch then it will find in outer level / parent
    static void nestedTryCatch() {
        try {
            String firstName = "ABC";
            firstName.length();
            try {
                int num = 50 / 0; //This try does not have catch of arithmetic exception
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (ArithmeticException e) {
            System.out.println("Catch not found in inner try-catch, Handled by outer catch");
            System.out.println(e);
        }
    }

    //3. Nested multiple try catch inside try catch
    static void nestedTryCatch2() {
        try {
            //inner try block 1
            try {
                System.out.println("going to divide by 0");
                int b = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            //inner try block 2
            try {
                int a[] = new int[5];

                //assigning the value out of array bounds
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
            System.out.println("other statement");
        }
        //catch block of outer try block
        catch (Exception e) {
            System.out.println("handled the exception (outer catch)");
        }
        System.out.println("normal flow..");
    }
}

//5. Finally - case in which finally does not execute
class Finally {
    public static void main(String[] args) {
        //dontThrow();
        //throwException();
        //throwExceptionUnhandled();
        notExecuteFinally();
    }


    //1. Exception does not occur
    static void dontThrow() {
        try {
            int num = 15 / 3;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally executed: No exception occurred");
        }
    }

    //2. Exception occur - Handled
    static void throwException() {
        try {
            throw new ArithmeticException(); //Method signature (throws) can be only added if it is checked exception
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally executed: Exception occurred & handled");
        }
    }

    //3. Exception occur - Not handled
    static void throwExceptionUnhandled() {
        try {
            throw new ArrayIndexOutOfBoundsException(); //Method signature (throws) can be only added if it is checked exception
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally executed: Exception occurred & not handled");
        }
    }

    //4. When finally will not execute? System.exit or fatal error -> abort
    static void notExecuteFinally() {
        try {
            int num = 9 / 3;
            System.exit(1);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally executed: Exception occurred & not handled");
        }
    }
}

//6. Throw keyword - throw exception explicitly
class ThrowKeyword {
    public static void main(String[] args) {
        //canVote(9);
        //System.out.println("Line below that may throw exception - not execute");

        //canVoteCheckedException(9); //declare thorows
        //System.out.println("Line below that may throw exception - not execute");

        //checkFile(); //Compile time error: checked exception must use under try catch or use throws

        try {
            // throw an object of user defined exception  
            throw new CustomError("This is user-defined exception");
        } catch (CustomError ude) {
            System.out.println("Caught the exception");
            // Print the message from MyException object  
            System.out.println(ude.getMessage());
        }
    }

    //1. throw unchecked exception - try catch & throws not mandatory
    static void canVote(int age) {
        if (age < 18) {
            throw new ArithmeticException("You are not eligible to vote");
        } else {
            System.out.println("Vote for your favourite neta!!");
        }
    }

    //2. throw checked exception - we must handle using try catch or declare in throws
    static void canVoteCheckedException(int age) throws IOException {
        if (age < 18) {
            throw new IOException("You are not eligible to vote");
        } else {
            System.out.println("Vote for your favourite neta!!");
        }
    }

    //3. Throwing user defined exception, we can also use throwable
    static class CustomError extends Exception {
        CustomError(String exception) {
            super(exception);
        }
    }


//    void userDefinedException() throws CustomError {
//        throw new CustomError("New custom error");
//    }


    //Other: Checked exception - must give method signature or use try catch, give compile time error
    static void checkFile() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    static void checkSQL() throws SQLException {
        throw new SQLException();
    }

    static void checkIOException() throws IOException {
        throw new IOException();
    }

    static void checkIOError() throws IOError {
        throw new IOError(new IOException());
    }

    //Ref:
    //1. [Error] https://www.javatpoint.com/throw-keyword#:~:text=Note%3A%20If%20we%20throw%20unchecked%20exception%20from%20a%20method%2C%20it%20is%20must%20to%20handle%20the%20exception%20or%20declare%20in%20throws%20clause.
}

//7. Every subclass of Error and RuntimeException is unchecked
//Checked exception is under Throwable class

/*
    8. Exception propagation
    Unchecked: forwarded in calling chain (propagated)
    Checked: not forwarded in calling chain (propagated)

    Stack (Only for unchecked)
    [method 3] <-- Exception occurred (Propogated to prev)
    [method 2]
    [method 1]
      [main]

      Reference:
        1. https://www.javatpoint.com/exception-propagation
*/
class ExceptionPropagation {
    public static void main(String[] args) {
        method1();
    }

    //3. Exception occurs here & not handled
    static void method3() {
        int data = 50 / 0;
    }

    //2. calls exception occurring method
    static void method2() {
        method3();
    }

    //1. Handling exception
    static void method1() {
        try {
            method2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
 * Throws : gives an information to the programmer that there may occur an exception
 * We need to catch exception
 * It does not handle
 * */
class ThrowsExample {
    public static void main(String[] args) throws IOException {

        //Propagation - with throws
        method1();
        System.out.println("Line below exception, Normal flow continues...");

        //Test error throwing functions - declare method signature as "throws"
        //exceptionNotOccur(); //May throw runtime error
        //exceptionOccur(); //Runtime error - Better to surround try-catch
    }

    //3. Exception occurs here & not handled
    static void method3() throws IOException {
        throw new IOException("Device Error"); //Checked exception
    }

    //2. calls exception occurring method
    static void method2() throws IOException {
        method3();
    }

    //1. Handling exception
    static void method1() {
        //Surround with try catch or declare as throws (Someone should catch it but we are not)
        try {
            method2();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Exception handled");
        }
    }

    static void exceptionOccur() throws IOException {
        throw new IOException();
    }

    static void exceptionNotOccur() throws IOException {
        System.out.println("IO Devices working");
    }
}





