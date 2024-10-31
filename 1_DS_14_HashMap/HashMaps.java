import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        // HashMap is an implementation of the Map interface

        // A (Hash)Map stores key-value pairs

        // HashMap is a generic class. You need to put the types
        // of the key and value in <>
        // Note: for primitive types, use the Wrapper Class
        // e.g. int -> Integer, boolean -> Boolean

        // Basically everything in a HashMap is O(1)
        // Adding, removing, replacing, getting are all O(1) average

        Map<String, String> countries = new HashMap<>();

        // Adding key-value pairs
        countries.put("USA", "Washington DC");
        countries.put("India", "New Delhi");
        countries.put("UK", "London");

        // Display the HashMap
        System.out.println(countries);

        // Removing a key-value pair
        countries.remove("USA");

        // Giving it a key that doesn't exist will simply ignore it
        countries.remove("Mexico"); // nothing happens

        // Get a value from key
        countries.get("India");

        // Get the number of pairs
        countries.size();

        // Putting the key again replaces it
        countries.put("UK", "Manchester");

        // Replace a value for a key
        countries.replace("UK", "London");
        // Note: difference between replace() and put() is that replace
        // will first check if the key exists. If it doesn't, there's nothing
        // to replace, so it will be ignored. put() will put in
        // a new entry anyway

        // Put if key is absent
        countries.putIfAbsent("Mexico", "Mexico City");
        // Note: will only add if the key doesn't exist. If it exists, ignore

        // Check if key exists in the HashMap
        countries.containsKey("USA");

        // Check if a value exists in the HashMap
        countries.containsValue("New Delhi");

        // Iteration
        for (String i : countries.keySet()) {
            System.out.println(i);
        }

        for (String i : countries.values()) {
            System.out.println(i);
        }

        for (Map.Entry<String, String> entry : countries.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // Clear all pairs in the HashMap
        countries.clear();

    }
}
