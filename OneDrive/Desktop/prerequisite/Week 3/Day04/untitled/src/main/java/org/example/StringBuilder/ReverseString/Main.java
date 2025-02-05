package org.example.StringBuilder.ReverseString;
import static org.example.StringBuilder.ReverseString.Reverse.reverseString;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(reverseString(str));
    }
}
