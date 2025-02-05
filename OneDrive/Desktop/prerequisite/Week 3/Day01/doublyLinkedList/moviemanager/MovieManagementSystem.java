package moviemanager;

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie at a specific position (1-based index)
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            System.out.println("Invalid position. Position must be 1 or greater.");
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds the number of nodes. Adding at the end.");
            addMovieAtEnd(title, director, year, rating);
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
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
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

                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found: " + title);
    }

    // Search for movies by director or rating
    public void searchMovies(String director, Double rating) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if ((director != null && current.director.equalsIgnoreCase(director)) ||
                (rating != null && current.rating == rating)) {
                System.out.println("Found: " + current.title + ", " + current.director + ", " +
                                   current.yearOfRelease + ", " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found matching the criteria.");
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        MovieNode current = head;
        System.out.println("\nMovies in Forward Order:");
        while (current != null) {
            System.out.println(current.title + ", " + current.director + ", " + current.yearOfRelease +
                               ", " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode current = tail;
        System.out.println("\nMovies in Reverse Order:");
        while (current != null) {
            System.out.println(current.title + ", " + current.director + ", " + current.yearOfRelease +
                               ", " + current.rating);
            current = current.prev;
        }
    }

    // Update the rating of a movie by title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found: " + title);
    }
}
