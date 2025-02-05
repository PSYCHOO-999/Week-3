package socialmedia;

import java.util.Scanner;

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaList socialMedia = new SocialMediaList();

        while (true) {
            System.out.println("\nSocial Media Friend Connections");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    socialMedia.addUser(id, name, age);
                }
                case 2 -> {
                    System.out.print("Enter User ID 1: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = scanner.nextInt();
                    socialMedia.addFriendConnection(userId1, userId2);
                }
                case 3 -> {
                    System.out.print("Enter User ID 1: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = scanner.nextInt();
                    socialMedia.removeFriendConnection(userId1, userId2);
                }
                case 4 -> {
                    System.out.print("Enter User ID 1: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = scanner.nextInt();
                    socialMedia.findMutualFriends(userId1, userId2);
                }
                case 5 -> {
                    System.out.print("Enter User ID to display friends: ");
                    int userId = scanner.nextInt();
                    socialMedia.displayFriends(userId);
                }
                case 6 -> {
                    System.out.print("Search by 1. Name or 2. User ID: ");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter Name: ");
                        scanner.nextLine(); // Consume newline
                        String name = scanner.nextLine();
                        socialMedia.searchUser(name, null);
                    } else {
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        socialMedia.searchUser(null, userId);
                    }
                }
                case 7 -> socialMedia.countFriends();
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
