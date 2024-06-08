import java.util.ArrayList;

public class TwoDArrayList {
    public static void main(String[] args) {
        // 2D ArrayList = a dynamic list of lists
        // Can change the size of these during runtime

        ArrayList<String> bakeryList = new ArrayList<>();
        bakeryList.add("pasta");
        bakeryList.add("donuts");
        bakeryList.add("garlic bread");

        ArrayList<String> produceList = new ArrayList<>();
        produceList.add("tomatoes");
        produceList.add("zucchini");
        produceList.add("peppers");
        produceList.add("carrots");

        ArrayList<String> drinksList = new ArrayList<>();
        drinksList.add("soda");
        drinksList.add("coffee");

        // 2D ArrayList
        ArrayList<ArrayList<String>> shoppingList = new ArrayList<>();
        shoppingList.add(bakeryList);
        shoppingList.add(produceList);
        shoppingList.add(drinksList);

        // Access
        System.out.println(shoppingList.get(0).get(2));

        // Iteration
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println(shoppingList.get(i));
        }

    }
}
