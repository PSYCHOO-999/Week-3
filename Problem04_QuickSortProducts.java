import java.util.Arrays;

public class Problem04_QuickSortProducts {
    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function (Lomuto partition scheme)
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1; // Pointer for smaller elements

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot at its correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Returning the pivot index
    }

    // Main function to test Quick Sort
    public static void main(String[] args) {
        double[] productPrices = {599.99, 249.50, 349.75, 799.25, 149.99, 199.90};

        System.out.println("Original product prices: " + Arrays.toString(productPrices));

        // Sorting using Quick Sort
        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted product prices: " + Arrays.toString(productPrices));
    }
}
