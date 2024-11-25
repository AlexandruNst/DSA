public class MergeSort {
    public static void main(String[] args) {
        // Merge Sort - Recursively divide an array in 2, sort, and re-merge
        // TC: O(n log n) faster than bubble, selection, insetion
        // SC: O(n) more than bubble, selection, insertion

        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };

        for (int i : array) {
            System.out.print(i);
        }

        System.out.println();

        mergeSort(array);

        for (int i : array) {
            System.out.print(i);
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        // divide the array in 2 each time.
        // if length is 1, there is no need to divide further
        if (length <= 1)
            return; // base case

        // Split the array in 2 halves
        int middle = length / 2;

        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int left = 0; // leftArray
        int right = 0; // rightArray

        for (int i = 0; i < length; i++) {
            if (i < middle) {
                leftArray[left] = array[i];
                left++;
            } else {
                rightArray[right] = array[i];
                right++;
            }
        }

        // recursively mergeSort the two halves
        mergeSort(leftArray);
        mergeSort(rightArray);

        // merge the two halves after sorting
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int index = 0; // original array
        int left = 0; // left array
        int right = 0; // right array

        // check the conditions for merging
        while (left < leftSize && right < rightSize) { // while there are elements in both left and right subarrays
            if (leftArray[left] < rightArray[right]) {
                array[index] = leftArray[left];
                index++;
                left++;
            } else {
                array[index] = rightArray[right];
                index++;
                right++;
            }
        }
        // elements left in either subarray
        while (left < leftSize) {
            array[index] = leftArray[left];
            index++;
            left++;
        }
        while (right < rightSize) {
            array[index] = rightArray[right];
            index++;
            right++;
        }
    }
}