public class InsertionSort {
    public static void main(String[] args) {
        // Insertion Sort - iterate through the array, and for each element
        // consider the subarray to the left. Shift elements to the right
        // until the element that is smaller that our element, effectively
        // inserting our element in place.

        // TC: O(n^2)

        // Best case is O(n) compared to Selection and Bubble Sorts O(n^2)

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        insertionSort(array);

        for (int i : array) {
            System.out.print(i);
        }
    }

    private static void insertionSort(int[] array) {
        // start at 1 so as to have a left subarray
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            // start to the left of i
            int j = i - 1;

            // while we have elements, and they're bigger than our element, shift right
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            // at the end, we have left subarray (smaller), gap, right subarray (bigger)
            // insert our element in the gap
            array[j + 1] = temp;
        }
    }
}
