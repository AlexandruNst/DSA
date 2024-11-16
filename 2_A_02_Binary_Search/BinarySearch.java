import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        // Binary Search - Search algorithm that finds the position of a
        // target value in a sorted array.
        // Half the array is discared during each step

        // Pro: Excellent for large data sets
        // Con: Data needs to be sorted

        // TC: O(log n)

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int target = 42;

        // there is a built-in binary search method
        int index = Arrays.binarySearch(array, target);
        System.out.println(index);

        int indexTwo = binarySearch(array, target);
        System.out.println(indexTwo);
    }

    private static int binarySearch(int[] array, int target) {
        // set boundaries
        int low = 0;
        int high = array.length - 1;

        // iterate while we still have an available window
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int value = array[mid];

            // value found
            if (value == target)
                return mid;
            // discard the left half
            else if (value < target)
                low = mid + 1;
            // discard the right half
            else
                high = mid - 1;
        }

        // if target not found, return sentinel value of -1
        return -1;
    }
}
