package singlyLinkedList.studentRecordManagement;

public class StudentLinkedList {
    private Student head;

    // Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add a new student record at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Record not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Record deleted.");
        }
    }

    // Display all student records
    public void displayRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + ", " + temp.name + ", " + temp.age + ", " + temp.grade);
            temp = temp.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found.");
    }
}
