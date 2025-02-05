package cpuscheduling;

public class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}
