package problemstatements.searchalgoanalysis;

import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }
            int target = data[rand.nextInt(size)]; // Pick a random target from the dataset

            // Linear Search
            long startTime = System.nanoTime();
            linearAndBinary.linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Binary Search (Sorting First)
            Arrays.sort(data);
            startTime = System.nanoTime();
            linearAndBinary.binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println("-----------------------------------");
        }
    }
}