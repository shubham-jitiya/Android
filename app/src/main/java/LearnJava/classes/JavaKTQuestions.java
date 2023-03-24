package LearnJava.classes;

public class JavaKTQuestions implements Game, Warrior {
    public static void foo1() {
        System.out.println("Hello, World!");
    }
    public static void main(String[] args) {
        //1. Multiple interfaces
        JavaKTQuestions testing = new JavaKTQuestions();
        testing.teamSize();
        testing.testMatch();
        testing.testMatchResult();

        //2. Downcasting using instance of
        BaseA testCasting = new BaseB();
        testCasting.fooA();

        if (testCasting instanceof BaseB)
            System.out.println("A has instance of B");

        //3. Labeled loops
        outer:
        for (int i = 0; i < 5; i++) {
            inner:
            for (int j = 0; j < 5; j++) {
                System.out.print(i + "" + j + " ");
                if (i == 2) {
                    break inner;
                }
            }
            System.out.println();
        }
        //void vd = foo1(); //void is keyword
    }

    //1. Multiple interfaces
    @Override
    public void teamSize() {
        System.out.println("Two player game");
    }

    @Override
    public void testMatch() {
        Game.super.testMatch();
        Warrior.super.testMatch();
        System.out.println("Calling testMatch() from implementing class");
    }

    @Override
    public void testMatchResult() {
        //Game.super.testMatchResult();
        System.out.println("Calling testMatchResult() from implementing class");
    }

    public static void foo() {
    }

/*  //static methods can not be overrided
    @Override
    public void foo2() {  }*/
}

//interface
interface Game {
    //1. Do we have properties with final?
    public final int winningPoints = 50; //We can have properties with final but not methods
    //public static final int winningPoints =  50;

    //2. Why we do not have methods with final?
    //an interface cannot have a final modifier because interfaces are designed to define methods
    // and constants that must be implemented by its implementing class
    //public final void teamSize(); //Invalid
    public void teamSize();

    //3. Default implementation
    default void testMatch() {
        System.out.println("Starting test match ... From Game");
    }

    //can have more than 1 default methods
    default void testMatchResult() {
        System.out.println("Test match result: successfully passed");
    }
}

interface Warrior {


    //3. Default implementation
    default void testMatch() {
        System.out.println("Starting test match ... From Warrior game");
    }

    default void testMatchResult() {
        System.out.println("Test match result: successfully passed");
    }

    public static void foo2() {

    } // can we override it, No ?
}

//2. Casting examples
class BaseA {
    int ageA = 0;

    void fooA() {
    }
}

class BaseB extends BaseA {
    int ageB = 0;

    void fooB() {
    }

}

class DefaultModifier {
    abstract static interface interfaceIA {
        public static final int age = 10;

        public abstract void foo();

        public default void foo1() {
        } // from java 8

        public static void foo2() {
        } // from java 8
    }

}

