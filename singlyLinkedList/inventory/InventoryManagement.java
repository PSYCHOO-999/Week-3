package inventory;

import java.util.Scanner;

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display Inventory");
            System.out.println("6. Calculate Total Value");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Price (Descending)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Position (1 for beginning, 2 for end): ");
                    int position = scanner.nextInt();
                    if (position == 1) {
                        inventory.addAtBeginning(name, id, quantity, price);
                    } else {
                        inventory.addAtEnd(name, id, quantity, price);
                    }
                }
                case 2 -> {
                    System.out.print("Enter Item ID to remove: ");
                    int id = scanner.nextInt();
                    inventory.removeById(id);
                }
                case 3 -> {
                    System.out.print("Enter Item ID to update: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.updateQuantityById(id, quantity);
                }
                case 4 -> {
                    System.out.print("Search by 1. ID or 2. Name: ");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter Item ID: ");
                        int id = scanner.nextInt();
                        inventory.searchById(id);
                    } else {
                        System.out.print("Enter Item Name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        inventory.searchByName(name);
                    }
                }
                case 5 -> inventory.displayItems();
                case 6 -> inventory.calculateTotalValue();
                case 7 -> {
                    inventory.sortByName();
                    System.out.println("Sorted by Name.");
                }
                case 8 -> {
                    inventory.sortByPriceDescending();
                    System.out.println("Sorted by Price (Descending).");
                }
                case 9 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
