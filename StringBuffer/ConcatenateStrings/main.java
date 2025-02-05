package org.example.StringBuffer.ConcatenateStrings;
import static org.example.StringBuffer.ConcatenateStrings.Concatenate.concatenateStrings;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First string: ");
        String str1 = input.nextLine();
        System.out.print("Enter Second string: ");
        String str2 = input.nextLine();

        String Result = concatenateStrings(str1, str2);
        System.out.println(Result);
    }
}
