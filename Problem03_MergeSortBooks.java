import java.util.Arrays;

public class Problem03_MergeSortBooks {
    // Merge Sort function
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle index

            // Recursively divide the array into two halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge function to merge two sorted subarrays
    public static void merge(double[] prices, int left, int mid, int right) {
        // Create temporary arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        double[] leftArray = new double[leftSize];
        double[] rightArray = new double[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        // Merge the two arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray (if any)
        while (i < leftSize) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray (if any)
        while (j < rightSize) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function to test Merge Sort
    public static void main(String[] args) {
        double[] bookPrices = {399.99, 149.50, 299.75, 549.25, 99.99, 199.90};

        System.out.println("Original book prices: " + Arrays.toString(bookPrices));

        // Sorting using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Sorted book prices: " + Arrays.toString(bookPrices));
    }
}
