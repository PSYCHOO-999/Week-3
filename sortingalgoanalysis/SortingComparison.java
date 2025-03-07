package problemstatements.sortingalgoanalysis;

import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);
            int[] array1 = generateRandomArray(size);
            int[] array2 = array1.clone();
            int[] array3 = array1.clone();

            // Bubble Sort (Inefficient for large data)
            long startTime = System.nanoTime();
            SortingAlgorithms.bubbleSort(array1);
            long bubbleSortTime = System.nanoTime() - startTime;
            System.out.println("Bubble Sort Time: " + bubbleSortTime / 1_000_000.0 + " ms");

            // Merge Sort (Efficient & Stable)
            startTime = System.nanoTime();
            SortingAlgorithms.mergeSort(array2, 0, size - 1);
            long mergeSortTime = System.nanoTime() - startTime;
            System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");

            // Quick Sort (Efficient but Unstable)
            startTime = System.nanoTime();
            SortingAlgorithms.quickSort(array3, 0, size - 1);
            long quickSortTime = System.nanoTime() - startTime;
            System.out.println("Quick Sort Time: " + quickSortTime / 1_000_000.0 + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Method to generate a random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100000); // Random numbers up to 100000
        }
        return array;
    }
}
