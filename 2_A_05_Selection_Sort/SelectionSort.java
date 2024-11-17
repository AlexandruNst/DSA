public class SelectionSort {
    public static void main(String[] args) {
        // Selection Sort - at each step find the min and place it
        // at the start of the array

        // TC: O(n^2)

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        selectionSort(array);

        for (int i : array) {
            System.out.print(i);
        }
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos])
                    minPos = j;
            }
            swap(array, minPos, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
