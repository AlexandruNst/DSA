import java.util.ArrayList;

public class ArrayListTutorial {
    public static void main(String[] args) {
        // ArrayList = Collection. A resizable array. Elements can be added and removed
        // after compilation phase
        // Can only store reference data types (i.e. not primitives, for these you need
        // to use the wrapper class)

        ArrayList<String> food = new ArrayList<>();

        // Adding
        food.add("Pizza");
        food.add("Hot Dog");
        food.add("Hamburger");

        // Iteration
        for (int i = 0; i < food.size(); i++) {
            System.out.print(food.get(i) + " ");
        }

        // Useful methods
        food.set(1, "Sushi");

        food.remove("Pizza");
        food.remove(0);

        food.clear(); // clear all elements in the ArrayList
    }
}
