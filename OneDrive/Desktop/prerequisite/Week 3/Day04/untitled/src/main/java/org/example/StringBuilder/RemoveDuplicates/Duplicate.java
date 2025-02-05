package org.example.StringBuilder.RemoveDuplicates;
import java.util.*;
public class Duplicate {
    public static void removeDuplicates(String str) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                temp.append(str.charAt(i));
            }
        }
        str =  temp.toString();
        System.out.println(str);
    }
}
