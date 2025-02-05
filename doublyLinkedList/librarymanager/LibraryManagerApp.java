package librarymanager;

import java.util.Scanner;

public class LibraryManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    library.addBookAtBeginning(title, author, genre, bookID, isAvailable);
                }
                case 2 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    library.addBookAtEnd(title, author, genre, bookID, isAvailable);
                }
                case 3 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    library.addBookAtPosition(title, author, genre, bookID, isAvailable, position);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to Remove: ");
                    int bookID = scanner.nextInt();
                    library.removeBookByID(bookID);
                }
                case 5 -> {
                    System.out.print("Search by 1. Title or 2. Author: ");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter Title: ");
                        scanner.nextLine(); // Consume newline
                        String title = scanner.nextLine();
                        library.searchBook(title, null);
                    } else {
                        System.out.print("Enter Author: ");
                        scanner.nextLine(); // Consume newline
                        String author = scanner.nextLine();
                        library.searchBook(null, author);
                    }
                }
                case 6 -> {
                    System.out.print("Enter Book ID to Update Availability: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Enter New Availability (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    library.updateAvailability(bookID, isAvailable);
                }
                case 7 -> library.displayBooksForward();
                case 8 -> library.displayBooksReverse();
                case 9 -> System.out.println("Total Books: " + library.countBooks());
                case 10 -> {
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
