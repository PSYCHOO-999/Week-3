package org.example.StringBuilder.RemoveDuplicates;
import static org.example.StringBuilder.RemoveDuplicates.Duplicate.removeDuplicates;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

//        String result = removeDuplicates(str);
//        System.out.println(result);

        removeDuplicates(str);
    }
}
