package LearnJava.classes;

public class OOPS {
    public static void main(String[] args) {

        Addition calcOne = new Addition();
        calcOne.addition(5, 2);
        System.out.println("Addition: " + calcOne.sum);

        PremiumCalc premiumCalc = new PremiumCalc();
        System.out.println("Multiplication: " + premiumCalc.multiply(5, 2));
    }
}

class Addition {
    int sum;

    void addition(int num1, int num2) {
        sum = num1 + num2;
    }

    void subtraction(int num1, int num2) {
        sum = num1 - num2;
    }
}

/*
Inheritance:
    subclass inherits all the members (fields, methods, and nested classes) from its superclass
    NOT CONSTRUCTOR - they are not member

Super:
    differentiate the members - super & subclass
    invoke superclass constructor
 */
class PremiumCalc extends Addition {
    int multiply(int num1, int num2) {
        sum = num1 * num2;
        return sum;
    }
}

class Superclass {
    int age;

    Superclass(int age) {
        this.age = age;
        System.out.println("Super constructor called");
    }

    public void getAge() {
        System.out.println("Age: " + age);
    }
}

class Subclass extends Superclass {
    Subclass(int age) {
        super(age);
        this.age = age;
        System.out.println("Subclass constructor called");
    }

    public static void main(String args[]) {
        Subclass s = new Subclass(24);
        s.getAge();
    }
}

class A {
    A() {
        System.out.println("In A ");
    }

    A(int i) {
        System.out.println("In A int");
    }
}

class B extends A {
    B() {
        //super(); by default
        super(5);
        System.out.println("In B ");
    }

    B(int i) {
        //super(); // by default
        super(5);
        System.out.println("In B int");
    }
}

class SuperClass {
    public static void main(String[] args) {
//        A obj1 = new A();
//        B obj2 = new B();
        B obj2 = new B(); //It will call default constructor of super class + paramatrised of sub class
    }
}