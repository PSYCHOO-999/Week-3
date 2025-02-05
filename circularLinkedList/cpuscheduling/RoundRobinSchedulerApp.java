package cpuscheduling;

import java.util.Scanner;

public class RoundRobinSchedulerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the time quantum: ");
        int timeQuantum = scanner.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        while (true) {
            System.out.println("\nRound Robin CPU Scheduling");
            System.out.println("1. Add Process");
            System.out.println("2. Display All Processes");
            System.out.println("3. Start Scheduling");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processID = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(processID, burstTime, priority);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    scheduler.schedule();
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
