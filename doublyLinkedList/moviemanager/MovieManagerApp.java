package moviemanager;

import java.util.Scanner;

public class MovieManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManagementSystem movieManager = new MovieManagementSystem();

        while (true) {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movies");
            System.out.println("6. Display Movies Forward");
            System.out.println("7. Display Movies Reverse");
            System.out.println("8. Update Movie Rating");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    movieManager.addMovieAtBeginning(title, director, year, rating);
                }
                case 2 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    movieManager.addMovieAtEnd(title, director, year, rating);
                }
                case 3 -> {
                    System.out.print("Enter Title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    movieManager.addMovieAtPosition(title, director, year, rating, position);
                }
                case 4 -> {
                    System.out.print("Enter Title to Remove: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    movieManager.removeMovieByTitle(title);
                }
                case 5 -> {
                    System.out.print("Search by 1. Director or 2. Rating: ");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 1) {
                        System.out.print("Enter Director: ");
                        scanner.nextLine(); // Consume newline
                        String director = scanner.nextLine();
                        movieManager.searchMovies(director, null);
                    } else {
                        System.out.print("Enter Rating: ");
                        double rating = scanner.nextDouble();
                        movieManager.searchMovies(null, rating);
                    }
                }
                case 6 -> movieManager.displayMoviesForward();
                case 7 -> movieManager.displayMoviesReverse();
                case 8 -> {
                    System.out.print("Enter Title to Update Rating: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = scanner.nextDouble();
                    movieManager.updateRating(title, newRating);
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
