package socialmedia;

import java.util.HashSet;
import java.util.List;

public class SocialMediaList {
    private UserNode head;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }

        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between User " + userId1 + " and User " + userId2);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        HashSet<Integer> mutualFriends = new HashSet<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        System.out.println("Mutual friends between User " + userId1 + " and User " + userId2 + ":");
        for (int friendId : mutualFriends) {
            System.out.println("Friend ID: " + friendId);
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of User " + userId + ":");
        for (int friendId : user.friendIds) {
            System.out.println("Friend ID: " + friendId);
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, Integer userId) {
        UserNode temp = head;
        while (temp != null) {
            if ((name != null && temp.name.equalsIgnoreCase(name)) || (userId != null && temp.userId == userId)) {
                System.out.println("User Found: " + temp.userId + ", " + temp.name + ", " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println("User " + temp.userId + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Helper: Find user by User ID
    private UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
