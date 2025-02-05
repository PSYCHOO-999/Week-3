package librarymanager;

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;
    private int totalBooks;

    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
        this.totalBooks = 0;
    }

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalBooks++;
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Position must be 1 or greater.");
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }

        BookNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds the number of books. Adding at the end.");
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; // Update tail if added at the end
        }
        current.next = newNode;
        newNode.prev = current;
        totalBooks++;
    }

    // Remove a book by Book ID
    public void removeBookByID(int bookID) {
        BookNode current = head;

        while (current != null) {
            if (current.bookID == bookID) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                totalBooks--;
                System.out.println("Book removed: " + current.title);
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found with ID: " + bookID);
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        BookNode current = head;
        boolean found = false;

        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) ||
                (author != null && current.author.equalsIgnoreCase(author))) {
                System.out.println("Found: " + current.title + ", " + current.author + ", " + current.genre +
                                   ", ID: " + current.bookID + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No books found matching the criteria.");
        }
    }

    // Update a book's availability status by Book ID
    public void updateAvailability(int bookID, boolean isAvailable) {
        BookNode current = head;

        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = isAvailable;
                System.out.println("Updated availability for book ID " + bookID + " to " + isAvailable);
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found with ID: " + bookID);
    }

    // Display all books in forward order
    public void displayBooksForward() {
        BookNode current = head;
        System.out.println("\nBooks in Forward Order:");
        while (current != null) {
            System.out.println(current.title + ", " + current.author + ", " + current.genre +
                               ", ID: " + current.bookID + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        BookNode current = tail;
        System.out.println("\nBooks in Reverse Order:");
        while (current != null) {
            System.out.println(current.title + ", " + current.author + ", " + current.genre +
                               ", ID: " + current.bookID + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        return totalBooks;
    }
}
