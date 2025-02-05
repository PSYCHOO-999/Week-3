package singlyLinkedList.studentRecordManagement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList srm = new StudentLinkedList();

        System.out.println("Student Record Management");
        System.out.println("Enter commands to manage records: ");
        System.out.println("1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number");
        System.out.println("5. Display All Records\n6. Update Grade\n7. Exit");

        while (true) {
            System.out.print("\nEnter command: ");
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> {
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    int roll = scanner.nextInt();
                    String name = scanner.next();
                    int age = scanner.nextInt();
                    char grade = scanner.next().charAt(0);
                    srm.addAtBeginning(roll, name, age, grade);
                }
                case 2 -> {
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    int roll = scanner.nextInt();
                    String name = scanner.next();
                    int age = scanner.nextInt();
                    char grade = scanner.next().charAt(0);
                    srm.addAtEnd(roll, name, age, grade);
                }
                case 3 -> {
                    System.out.print("Enter Position, Roll Number, Name, Age, Grade: ");
                    int pos = scanner.nextInt();
                    int roll = scanner.nextInt();
                    String name = scanner.next();
                    int age = scanner.nextInt();
                    char grade = scanner.next().charAt(0);
                    srm.addAtPosition(pos, roll, name, age, grade);
                }
                case 4 -> {
                    System.out.print("Enter Roll Number to delete: ");
                    int roll = scanner.nextInt();
                    srm.deleteByRollNumber(roll);
                }
                case 5 -> srm.displayRecords();
                case 6 -> {
                    System.out.print("Enter Roll Number and New Grade: ");
                    int roll = scanner.nextInt();
                    char grade = scanner.next().charAt(0);
                    srm.updateGrade(roll, grade);
                }
                case 7 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }
}
