package LearnJava.classes;

/*
 * Abstraction:  process of hiding the implementation details and showing only functionality to the user
 * Can be achieved by abstract or interface keyword
 *   An abstract class must be declared with an abstract keyword.
 *   It can have abstract and non-abstract methods.
 *   It cannot be instantiated.
 *   It can have constructors and static methods also.
 *   It can have final methods which will force the subclass not to change the body of the method.
 *
 * Difference
 * References:
 *      1. https://www.javatpoint.com/abstract-class-in-java
 *      2. https://www.w3schools.com/java/java_abstract.asp
 * */

public class Interface extends NewIOSRelease {
    public static void main(String[] args) {
        NewIOSRelease newUpdate = new NewIOSRelease();
        newUpdate.defaultFeatures();
        newUpdate.camera();

    }

    //example
    abstract class Bike {
        abstract void maxSpeed();

        abstract void breakingSystem();

        abstract void noSound();
    }

    class SportsBike extends Bike {
        @Override
        void maxSpeed() {
            System.out.println("max speed: 200 km/hr");
        }

        @Override
        void breakingSystem() {
            System.out.println("Disk breaks");
        }

        @Override
        void noSound() {
            System.out.println("Does not produce much noise");
        }
    }

    abstract class NormalBike extends Bike {
        @Override
        void maxSpeed() {
            System.out.println("max speed: 80 km/hr");
        }

        @Override
        void breakingSystem() {
            System.out.println("Drum breaks");
        }
        //abstract void noSound(); //must implement all abstract or make it abstract
    }

    //iOS 17 which does not have currently 5G service
    // but maybe implemented in future when 5G supports comes from network provider
    abstract class iOS17 {
         //int marks = 100; //valid
         //int marks; //valid
        //abstract int marks; //Invalid valid
        abstract void support5G(); //I can not create object until 5G service is implemented

        void camera() {
            System.out.println("50 MP, Triple camera");
        }
    }
}

//Interface:
//      - blueprint of a class. It has static constants and abstract methods
//      - only abstract not method body
//      - achieve multiple inheritance
//      - can have default static & private methods
//      -  all fields: public, static and final by default : must initialised
// Reference: https://www.javatpoint.com/interface-in-java

interface iOS17Beta {
    int version = 10;// can have but must initialised
    abstract void support5G(); //I can not create object until 5G service is implemented
}

//Once beta is developed I can extend it with below interface
//Before that if I extend I must need to provide implementation
interface iOS17Alpha {
    void camera();

    default void defaultFeatures() {
        System.out.println("Default implementation");
    }
}

class NewIOSRelease implements iOS17Alpha {
    @Override
    public void camera() {
        System.out.println("50 MP, Triple camera");

    }
}


/*
* Differences:
*
* Inheritance:
*       inherit implement multiple interfaces
*       does not have access modifiers, Everything is public
*       data field must be initialised
* Abstract :
*       inherit only one Abstract Class
*       can have an access modifier
*       data field can be initialised or can not be abstract
* */