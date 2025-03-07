package problemstatements.filereadingcomparison;

import java.io.*;

public class FileReadingComparison {

    public static void readUsingFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1) {} // Reading character by character
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.printf("FileReader Time: %,dns%n", elapsedTime);
    }

    public static void readUsingInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {} // Reading byte stream converted to characters
        }
        long elapsedTime = System.nanoTime() - startTime;
        System.out.printf("InputStreamReader Time: %,dns%n", elapsedTime);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\CapgeminiHandsOn\\learnings\\Java Strings Notes.docx";
        System.out.println("Comparing FileReader vs InputStreamReader:");
        readUsingFileReader(filePath);
        readUsingInputStreamReader(filePath);
    }
}
