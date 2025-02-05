package cpuscheduling;

public class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int timeQuantum;
    private int totalProcesses;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
        this.totalProcesses = 0;
    }

    // Add a process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        totalProcesses++;
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processID) {
        if (head == null) return;

        ProcessNode temp = head;
        ProcessNode prev = null;

        do {
            if (temp.processID == processID) {
                if (prev == null) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                totalProcesses--;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round-robin scheduling
    public void schedule() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode current = head;
        int totalWaitingTime = 0, totalTurnAroundTime = 0;

        while (totalProcesses > 0) {
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                // Process completes
                totalWaitingTime += current.waitingTime;
                totalTurnAroundTime += current.turnAroundTime;

                removeProcess(current.processID);

                System.out.println("Process " + current.processID + " completed.");

                current = current.next; // Move to the next process
            }
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) totalProcesses));
    }

    // Display all processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
