public class BubbleSort {
    public static void main(String[] args) {
        // Bubble Sort - pairs of adjacent elements are compared,
        // and swapped if not in order

        // TC: O(n^2)

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        bubbleSort(array);

        for (int i : array) {
            System.out.print(i);
        }

    }

    private static void bubbleSort(int[] array) {
        // first loop is for the amount of iteration needed
        for (int i = 0; i < array.length - 1; i++) {
            // second loop is iterating the array, till the newest bubbled item (- i)
            for (int j = 0; j < array.length - 1 - i; j++) {
                // if adjacent elements are out of order, swap
                if (array[j] > array[j + 1]) { // use < if we want a descending order
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}