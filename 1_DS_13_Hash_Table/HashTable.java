import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {
        // Hash Tables are collections of key-value pairs (named entries)
        // FAST for insertion, look up, deletion

        // the key is determined via a hashCode() method
        // it computes an integer that we % capacity
        // index = key.hashCode() % capacity

        // if the hashCode() function returns the same key => collision
        // solution is to turn each bucket (location for entries) into a Linked List
        // (named chaining)

        // Time complexity: Best Case O(1)
        // Worst Case O(n)

        // less collisions => better
        // to avoid collisions, increase the capacity of the table
        // or make a better hashing function

        Hashtable<Integer, String> table = new Hashtable<>(10);

        table.put(100, "Spongebob");
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "Squidward");
        table.put(777, "Gary");

        System.out.println(table.get(100));

        for (Integer key : table.keySet()) {
            System.out.println(key + "\t" + table.get(key));
        }

        table.remove(777);

        for (Integer key : table.keySet()) {
            System.out.println(key + "\t" + table.get(key));
        }
    }
}
