package socialmedia;

import java.util.ArrayList;
import java.util.List;

public class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of Friend IDs
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>(); // Initialize the list of friend IDs
        this.next = null;
    }
}
