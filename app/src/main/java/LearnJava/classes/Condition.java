package LearnJava.classes;

public class Condition {
    public static void main(String[] args) {
        int age = 21;

        if (age > 18) {
            System.out.println("You can vote");
        } else {
            System.out.println("You are not eligible");
        }

        //If else if else
        int agetwo = 59;
        if (agetwo > 59) {
            System.out.println("You are senior citizen");
        } else if (agetwo >= 18 && agetwo <= 59) {
            System.out.println("You are adult");
        } else if (agetwo < 18) {
            System.out.println("You are teenager");
        } else {
            System.out.println("Undefined");
        }

        //Ternary operator
        String canVote = (agetwo > 18) ? "You can vote" : "You can not!";
        System.out.println(canVote);

        //Switch
        int day = 7;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            default: //We can write this anywhere in switch
                System.out.println("Invalid day");
//                break; //no need to write this if default is at last

                //While
                int i = 5;
                while (i > 0) {
                    System.out.println(i);
                    i--;
                }

                //runs atleast once irrespective of condition is true or false
                do {
                    System.out.println("Do while executed");
                    System.out.println(i);
                } while (i < 0);

                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }

                //Break and continue in loops
                //continue
                for (int j = 0; j < 5; j++) {
                    if (j == 2) {
                        System.out.println("Skipping iteration");
                        continue;
                    }

                    System.out.println("i: " + j);
                }
                //break
                for (int j = 0; j < 5; j++) {
                    if (j == 2) {
                        System.out.println("moving out of loop");
                        break;
                    }

                    System.out.println("j: " + j);
                }

                //Create array and traverse
                String[] names = {"Shubham", "Bhakti", "Shyam", "Manthan"};
                for (String name : names) {
                    System.out.println(name);
                }
        }
    }
}
