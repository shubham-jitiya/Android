package LearnJava.classes;

public class Abstraction {
    /*
        Hide the internal details and show the functionality

    */
    public static void main(String[] args) {
        Animal newAnimal = new Pig();
        newAnimal.animalSound();
        newAnimal.sleep();

    }

    public static abstract class Animal {
        public abstract void animalSound();

        public void sleep() {
            System.out.println("animal is sleeping...");
        }
    }

    public static class Pig extends Animal {
        public void animalSound() {
            System.out.println("Oank.. oank");
        }
    }
}

