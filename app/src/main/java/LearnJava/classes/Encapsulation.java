package LearnJava.classes;

public class Encapsulation {
    /*
     * We must hide the sensitive data from the user
     * For that we use access modifiers & use getters & setters to access
     * User is not accessing properties directly
     * we can make read only or write only
     * */
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("John"); // Set the value of the name variable to "John"
        System.out.println(myObj.getName());
    }

    public static class Person {
        private String name; // private = restricted access

        // Getter
        public String getName() {
            return name;
        }

        // Setter
        public void setName(String newName) {
            this.name = newName;
        }
    }
}
