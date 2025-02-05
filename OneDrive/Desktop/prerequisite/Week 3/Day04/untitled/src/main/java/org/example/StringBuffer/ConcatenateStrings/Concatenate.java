package org.example.StringBuffer.ConcatenateStrings;

public class Concatenate {
    public static String concatenateStrings(String str1, String str2) {
        StringBuffer ans = new StringBuffer(str1.length() + str2.length());

        for (int i = 0; i < str1.length(); i++) {
            ans.append(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            ans.append(str2.charAt(i));
        }
        return ans.toString();
    }
}
