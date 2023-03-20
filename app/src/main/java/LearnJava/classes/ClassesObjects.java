package LearnJava.classes;

public class ClassesObjects {
    public static void main(String[] args) {
        /*
         * Object:
         *       state (data)
         *       behaviour(functionality)
         *       identity (jvm)
         *
         * Class:
         *      blueprint of object
         *      fields, methods, constructors, blocks, nested class
         *
         * variables:
         *      Local -
         *          inside methods, constructors or blocks
         *          variable will be destroyed when the method has completed
         *      Instance -
         *          inside the class but outside method
         *          accessed from inside any method, constructor or blocks of that particular class
         *      Class -
         *          same as instance variable
         *          with static keyword
         *
         * Ref:
         *      1. https://www.javatpoint.com/object-and-class-in-java
         *      2. https://www.tutorialspoint.com/java/java_object_classes.htm
         * */
        System.out.println("Hello, world");
    }
}

class Student {
    int id;
    String name;

    //methods
    void insertMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Constructor
    Student() { }
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void isPresent() {
        System.out.println("Student is present..");
    }
}

class School {
    public static void main(String[] args) {
        Student s1 = new Student();

        //1. Initialization through reference
        s1.id = 43;
        s1.name = "Shubham Jitiya";
        System.out.println("Enrollment id: " + s1.id);
        System.out.println("Name: " + s1.name);

        //2. Initialization through method
        s1.insertMethod(44, "Sartanpara Shyam");
        System.out.println("\nEnrollment id: " + s1.id);
        System.out.println("Name: " + s1.name);

        //3. Through constructor
        Student studentTwo = new Student(45, "Bhakti trivedi");
        System.out.println("\nEnrollment id: " + studentTwo.id + "\nName: " + studentTwo.name + "\n");

        /*
        Different ways of creating objects:
            By new keyword, newInstance(), clone() - used with asynchronous task, deserialization
        */

        //Anonymous object: no reference
        new Student().isPresent();

        //Anonymous class
        System.out.println("\nAnonymous class");
        Student nursery = new Student() {
            @Override
            void isPresent() {
                System.out.println("kid is present..");
            }
        };
        nursery.isPresent();
        System.out.println(nursery.id);

        //Multiple objects in one line
        Student primaryStudent = new Student(), scienceStudent = new Student();

    }
}

