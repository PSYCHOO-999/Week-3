package ticketreservationsystem;

import java.util.Scanner;

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\nOnline Ticket Reservation System");
            System.out.println("1. Book a New Ticket");
            System.out.println("2. Display All Tickets");
            System.out.println("3. Remove a Ticket");
            System.out.println("4. Search for a Ticket");
            System.out.println("5. Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character after integer input

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = scanner.nextLine();
                    system.addTicket(ticketID, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    system.displayTickets();
                    break;
                case 3:
                    System.out.print("Enter Ticket ID to Remove: ");
                    int removeTicketID = scanner.nextInt();
                    system.removeTicket(removeTicketID);
                    break;
                case 4:
                    System.out.print("Search by 1. Customer Name or 2. Movie Name: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (searchChoice == 1) {
                        System.out.print("Enter Customer Name: ");
                        String searchCustomerName = scanner.nextLine();
                        system.searchTicket(searchCustomerName, true);
                    } else {
                        System.out.print("Enter Movie Name: ");
                        String searchMovieName = scanner.nextLine();
                        system.searchTicket(searchMovieName, false);
                    }
                    break;
                case 5:
                    System.out.println("Total Booked Tickets: " + system.getTotalTickets());
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
