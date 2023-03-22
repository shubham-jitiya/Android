package LearnJava.classes;

/*
 * Enums: special "class" that represents a group of constants (unchangeable variables, like final variables)
 * Enum is short for "enumerations", which means "specifically listed"
 *
 * Enums vs classes:
 *      - enum constants are public static final (can not override)
 *      - cannot be used to create objects, and it cannot extend other classes (Because it already inherit Enum class internally & java doesn't support multiple inheritance)
 *      - but it can implement interfaces
 *      - can have fields, constructors and methods
 *
 * Ref:
 *  1. https://www.w3schools.com/java/java_enums.asp
 *  2. https://www.simplilearn.com/tutorials/java-tutorial/enum-in-java#:~:text=You%20can%20also%20have%20abstract,method%20for%20each%20constant%20value.
 *
 * */

enum OutsideEnum {
    MONDAY, TUESDAY, WEDNESDAY
}

public class Enums {

    //1. Define enum - inside class, can also define outside class
    enum Level {
        LOW,
        MEDIUM,
        HIGH;
        //int value = 10;
    }

    public static void main(String[] args) {

        //Access
        Level currentLevel = Level.LOW;
        System.out.println(currentLevel); //Inside class enum
        System.out.println(OutsideEnum.MONDAY); //Outside class enum

        //Use with switch
        switch (currentLevel) {
            case LOW:
                System.out.println("Easy mode");
                break;
            case MEDIUM:
                System.out.println("Medium mode");
                break;
            case HIGH:
                System.out.println("Hard mode");
                break;
        }

        //Loop
        //values() - returns an array of all constants
        for (Level lvl : Level.values()) {
            System.out.println(lvl);
        }

        //valueOf() - returns enum constant with its name
        System.out.println("valueOf(): " + Level.valueOf("LOW"));

        //ordinal() - its position in enum declaration
        //Initial constant is assigned zero
        System.out.println("ordinal(): " + Level.MEDIUM.ordinal());

        //Enum with initial values
        EnumWithValues enumWithValues = EnumWithValues.HIGH;
        System.out.println(enumWithValues);

        for (EnumWithValues enums : EnumWithValues.values()) {
            System.out.println(enums);
        }

        System.out.println(EnumWithValues.valueOf("LOW")); //how to get values of constant?
        System.out.println(EnumWithValues.LOW.getValue()); //Get values by getter
    }
}

//Run enum directly if enum is inside main
enum EnumInsideMain {
    LOW, MEDIUM, HIGH;

    public static void main(String[] args) {
        System.out.println(LOW);
    }
}

/*
    Initialise values to enum constants
    By default it has values from 0, 1...
    To assign values to each constants
          - We must have its constructor
          - Must give values to all constants
          - Two constants can have the same value
*/
enum EnumWithValues {
    LOW(1), MEDIUM(2), HIGH(3); //specifying initial values
    private int value; //It must be below constants
    //abstract void getValues(); // can we create abstract methods in enums?

    //Constructor is by default private - can not use new keyword
    EnumWithValues(int i) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}