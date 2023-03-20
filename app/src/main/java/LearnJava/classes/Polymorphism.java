package LearnJava.classes;

public class Polymorphism {
    /*
    achieved by overloading & overriding

    Compile time polymorphism
        - override static
    Runtime time polymorphism (dynamic method dispatch)
        - can be achieved by data members

    Ref:
        1. https://www.javatpoint.com/runtime-polymorphism-in-java
        2. https://www.w3schools.com/java/java_polymorphism.asp
    */

    public static void main(String[] args) {
        NewClass nc = new NewClass();

        //method overriding
        Animal newAlien = new Lion();
        newAlien.eat();
//        newAlien.p //We can't access play() only methods of Animal class is available and if it is overided by new object then it will be called

        //Multilevel inheritance & overriding
        Animal animalOne, animalTwo;
        animalOne = new Dog();
        animalTwo = new Lion();
        System.out.println();
        animalOne.eat();
        animalOne.eat();

        //Double can take float but float can't take double
        nc.takeInput(45.24234f);
    }

    //Method overriding
    public static class Animal {
        void eat() {
            System.out.println("Animal is eating...");
        }
    }

    public static class Dog extends Animal {
        void eat() {
            System.out.println("Dog is eating...");
        }
    }

    public static class Lion extends Animal {
        void eat() {
            System.out.println("Lion is eating...");
        }

        void play() {

        }
    }

    //Can we pass float to double and vice versa?
    public static class NewClass {
        void takeInput(double num) {
        }
    }
}


