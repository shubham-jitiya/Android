package LearnJava.classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Collection {
    public static void main(String[] args) {

    }
}

//ArrayList extends AbstractList implements List
//Ordered collection
class ArrayListPractice {
    public static void main(String[] args) {

        //Resizable array
        ArrayList<String> cars = new ArrayList<>();
       // List<String> cars = new ArrayList<>();

        //Add items
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mercedes");
        System.out.println(cars);

        //Access items
        System.out.println(cars.get(1));;

        //Change an item
        cars.set(1, "Nano");
        System.out.println(cars.get(1));

        //Remove an item
        cars.remove(1);
        System.out.println(cars);

        //Remove all elements
      /*  cars.clear();
        System.out.println(cars);*/

        //Find size
        System.out.println(cars.size());

        //Traverse
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        //Traverse using forEach loop
        for (String car: cars) {
            System.out.println(car);
        }

        //Use wrapper: to make array of primitive type
        //Because we can not create array of Array<int>
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(10);
        scores.add(0);
        scores.add(20);

        for(Integer score: scores) {
            System.out.println(score);
        }

        //Sort
        Collections.sort(cars);
        System.out.println(cars);
    }
}

/*
    Items: key - value
    Unordered, unique keys, if exist replaces,
    Another is HashTable - synchronised, thread safe
    HashMap - initial capacity = 16, load factor 0.75
        load factor - The load factor is the measure that decides when to increase the capacity of the Map.
    References Used:
        1. https://www.w3schools.com/java/java_hashmap.asp
*/
class MapPractice {
    public static void main(String[] args) {

        //Declare - HashMap
        //HashMap<String, String> capitalCities = new HashMap<>();
        Map<String, String> capitalCities = new HashMap<>();

        //Add items
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        //Access items
        System.out.println(capitalCities.get("USA"));

        //Remove
        System.out.println("Removed: " + capitalCities.remove("USA"));
        System.out.println(capitalCities);

        //Size
        System.out.println("Size: " + capitalCities.size());

        //Traverse - Only keys
        for (String city: capitalCities.keySet()) {
            System.out.println(city);
        }
        //Traverse - Only values
        for (String capital: capitalCities.values()) {
            System.out.print(capital + " ");
        }
    }
}

/*
* Similar to ArrayList - both implement the List interface
*   - Add change remove clear is same as ArrayList
* But both works differently
*   Array - creates new array and removes old if size is small
*   LinkedList - each container links to next
*
* Use?
*   Array - Storing & accessing
*   LinkedList - Manipulating
* */
class LinkedListPractice {
    public static void main(String[] args) {
    LinkedList<String> toppers = new LinkedList<>();
    toppers.add("Shubham");
    toppers.add("Bhakti");
    toppers.add("Shyam");
    toppers.add("Manthan");

    //get
    System.out.println(toppers.getFirst());
    System.out.println(toppers.getLast());

    //remove
    System.out.println(toppers.removeFirst());
    System.out.println(toppers.removeLast());

        System.out.println(toppers);
    }
}