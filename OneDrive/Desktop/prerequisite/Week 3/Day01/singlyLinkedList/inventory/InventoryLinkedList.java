package inventory;

public class InventoryLinkedList {
    private InventoryItem head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove an item by Item ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search for an item by Item ID
    public void searchById(int itemId) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + ", " + temp.itemId + ", " + temp.quantity + ", " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search for an item by Item Name
    public void searchByName(String itemName) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + ", " + temp.itemId + ", " + temp.quantity + ", " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryItem temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Display all items in the inventory
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryItem temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println(temp.itemName + ", " + temp.itemId + ", " + temp.quantity + ", " + temp.price);
            temp = temp.next;
        }
    }

    // Sort items by Item Name (Ascending Order)
    public void sortByName() {
        if (head == null || head.next == null) {
            return;
        }
        for (InventoryItem i = head; i.next != null; i = i.next) {
            for (InventoryItem j = head; j.next != null; j = j.next) {
                if (j.itemName.compareToIgnoreCase(j.next.itemName) > 0) {
                    swap(j, j.next);
                }
            }
        }
    }

    // Sort items by Price (Descending Order)
    public void sortByPriceDescending() {
        if (head == null || head.next == null) {
            return;
        }
        for (InventoryItem i = head; i.next != null; i = i.next) {
            for (InventoryItem j = head; j.next != null; j = j.next) {
                if (j.price < j.next.price) {
                    swap(j, j.next);
                }
            }
        }
    }

    private void swap(InventoryItem a, InventoryItem b) {
        String tempName = a.itemName;
        int tempId = a.itemId;
        int tempQuantity = a.quantity;
        double tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemId = b.itemId;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemId = tempId;
        b.quantity = tempQuantity;
        b.price = tempPrice;
    }
}
