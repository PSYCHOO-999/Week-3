package problemstatements.stringconcatenationanalysis;

public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            // Using String (Inefficient)
            long startTime = System.nanoTime();
            StringConcatenation.concatenateString(size);
            long stringTime = System.nanoTime() - startTime;
            System.out.println("String Concatenation Time: " + stringTime / 1_000_000.0 + " ms");

            // Using StringBuilder (Efficient)
            startTime = System.nanoTime();
            StringConcatenation.concatenateStringBuilder(size);
            long stringBuilderTime = System.nanoTime() - startTime;
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1_000_000.0 + " ms");

            // Using StringBuffer (Thread-safe, slightly slower)
            startTime = System.nanoTime();
            StringConcatenation.concatenateStringBuffer(size);
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1_000_000.0 + " ms");

            System.out.println("-----------------------------------");
        }
    }
}
