import java.util.Arrays;

public class Problem06_HeapSortSalaries {
    // Heap Sort function
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Step 1: Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with the last element
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Reheapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify function to maintain the Max Heap property
    public static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than current largest
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest is not root, swap and continue heapifying
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Main function to test Heap Sort
    public static void main(String[] args) {
        double[] salaryDemands = {55000, 40000, 70000, 50000, 80000, 60000};

        System.out.println("Original salary demands: " + Arrays.toString(salaryDemands));

        // Sorting using Heap Sort
        heapSort(salaryDemands);

        System.out.println("Sorted salary demands: " + Arrays.toString(salaryDemands));
    }
}
