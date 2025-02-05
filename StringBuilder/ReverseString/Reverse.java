package org.example.StringBuilder.ReverseString;

public class Reverse {
    public static String reverseString(String str) {
//        StringBuilder reversed = new StringBuilder(str);
//        reversed.reverse();
        return new StringBuilder(str).reverse().toString();
    }
}
