public class QuickSort {
    public static void main(String[] args) {

        // Quick Sort - partition the array based on a pivot,
        // elements smaller to the left, elements greater to the right,
        // then recursively do the same thing to the 2 partitions
        // (not including the pivot) until the base case of 1 elem in the partition

        // TC: Best & Average O(n logn), Worst O(n^2) if array is already sorted
        // SC: O(logn) for the recursive stack

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        quickSort(array);

        for (int i : array) {
            System.out.print(i);
        }
    }

    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int start, int end) {
        // base case. we can't divide the array further
        if (end <= start)
            return;

        // partition the array in place
        int pivotIndex = partition(array, start, end);

        // recursively sort the left and right paritions
        quickSortHelper(array, start, pivotIndex - 1);
        quickSortHelper(array, pivotIndex + 1, end);
    }

    // This implementation uses in-place partitioning, which avoids creating
    // additional arrays and is memory-efficient.
    private static int partition(int[] array, int start, int end) {
        // choose pivot. In this implementation, we choose the end element of the array
        int pivotIndex = end;

        // partition the array into 2, less than pivot, and greater than pivot
        int pivotValue = array[pivotIndex];

        int i = start;
        for (int j = start; j <= pivotIndex - 1; j++) {
            if (array[j] < pivotValue) {
                swap(array, i, j);
                i++;
            }
        }

        // put the pivot (currently in index end) in its place (i)
        swap(array, i, pivotIndex);

        return i; // new (final) location of pivot
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
