package librarymanager;

public class BookNode {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
