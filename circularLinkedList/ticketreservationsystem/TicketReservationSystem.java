package ticketreservationsystem;

public class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;
    private int totalTickets;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular reference
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular structure
        }
        totalTickets++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) return;

        TicketNode temp = head;
        TicketNode prev = null;

        do {
            if (temp.ticketID == ticketID) {
                if (prev == null) { // Removing the head node
                    head = head.next;
                    tail.next = head; // Maintain circular structure
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev; // Update tail if we are removing the last node
                    }
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketID + " removed.");
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName + ", Movie: " + temp.movieName
                    + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query, boolean searchByCustomer) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;
        do {
            if ((searchByCustomer && temp.customerName.equalsIgnoreCase(query)) ||
                (!searchByCustomer && temp.movieName.equalsIgnoreCase(query))) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName + ", Movie: " + temp.movieName
                        + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for the search query.");
        }
    }

    // Calculate total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}
