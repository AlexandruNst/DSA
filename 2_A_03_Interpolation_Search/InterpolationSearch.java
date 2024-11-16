public class InterpolationSearch {
    public static void main(String[] args) {
        // Interpolation Search - improvement over Binary Search
        // Used for "uniformly/evenly" distributed data
        // Binary Search will always guess the middle of the window
        // Interpolation Search will guess taking into account
        // the value and the window length

        // Basically, if your window is 1-10 and you're looking for 9,
        // it will assume you're looking towards the end of the window,
        // instead of the middle

        // TC: Average O(log(log n)), Worst O(n) when values increase exponentially

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int target = 42;

        int index = interpolationSearch(array, target);
        System.out.println(index);

    }

    private static int interpolationSearch(int[] array, int value) {
        int high = array.length - 1;
        int low = 0;

        while (value >= array[low] && value <= array[high] && low < high) {
            // similar to BS, but trying to have a smarter guess, given the data is uniform
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);

            if (array[probe] == value)
                return probe;
            else if (array[probe] < value)
                low = probe + 1;
            else
                high = probe - 1;
        }

        return -1;
    }
}
