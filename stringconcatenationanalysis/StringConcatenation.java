package problemstatements.stringconcatenationanalysis;

public class StringConcatenation {
    public static void concatenateString(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += "a"; // Creates new object each time
        }
    }

    public static void concatenateStringBuilder(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Efficient appending
        }
    }

    public static void concatenateStringBuffer(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Thread-safe but slightly slower
        }
    }
}
