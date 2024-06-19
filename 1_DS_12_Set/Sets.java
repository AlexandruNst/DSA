import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        // Set = a data structure that holds unique elements
        // will not hold items in order
        // In Java, Set is an interface, we use a HashSet most often
        // A HashSet uses a Hash Table behind the scenes

        Set<String> names = new HashSet<>();

        names.add("Walter");
        names.add("Jesse");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");

        System.out.println(names); // will be printed in a different order than added

        names.add("Mike"); // this will not be added to the set, as it's a duplicate

        System.out.println(names);

        names.remove("Mike");

        System.out.println(names);

        // Other useful methods
        names.size();
        names.contains("Mike");
        names.isEmpty();
        // names.clear();

        // Iteration
        for (String name : names) {
            System.out.println(name);
        }

        Iterator<String> nameIterator = names.iterator();
        while (nameIterator.hasNext()) {
            String name = nameIterator.next();
            System.out.println(name);
        }

        // Lambda
        names.forEach(System.out::println);

        // Another Set implementation
        Set<String> treeSet = new TreeSet<>();
        // A TreeSet is a Set where elements are stored in natural order
        // TreeSet is much slower than a HashSet
        treeSet.add("Walter");
        treeSet.add("Jesse");
        treeSet.add("Skyler");
        treeSet.add("Saul");

        System.out.println(treeSet);

        // Yet another Set implementation
        Set<String> linkedHashSet = new LinkedHashSet<>();
        // A LinkedHashSet is a Set where elements are stored in the insertion order
        // LinkedHashSet is about as fast as a HashSet, slightly slower
        linkedHashSet.add("Walter");
        linkedHashSet.add("Jesse");
        linkedHashSet.add("Skyler");
        linkedHashSet.add("Saul");

        System.out.println(linkedHashSet);
    }
}
