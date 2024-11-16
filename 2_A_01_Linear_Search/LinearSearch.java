public class LinearSearch {
    public static void main(String[] args) {
        // Linear Search - Iterate through a collection, one element at a time
        // TC: O(n) - iterate the collection

        // Con: Slow for large data sets
        // Pros:
        // Fast on small & media data sets,
        // Data does NOT need to be sorted!
        // Useful for data structures with no random access (e.g. lists)

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        int index = linearSearch(array, 7);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

    private static int linearSearch(int[] array, int value) {
        // iterate though the array
        for (int i = 0; i < array.length; i++) {
            // if value is found, return the index i
            if (array[i] == value) {
                return i;
            }
        }

        // if value is not found, return sentinel value -1
        return -1;
    }
}
