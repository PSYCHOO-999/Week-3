import java.util.Scanner;

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor(10); // Limit the history size to 10

        while (true) {
            System.out.println("\nText Editor");
            System.out.println("1. Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new text: ");
                    String content = scanner.nextLine();
                    editor.addState(content);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrentState();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
