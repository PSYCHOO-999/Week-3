public class TextEditor {
    private TextNode currentState;
    private TextNode undoHead;
    private TextNode redoHead;
    private int maxHistorySize;
    private int historySize;

    public TextEditor(int maxHistorySize) {
        this.currentState = new TextNode("");
        this.undoHead = this.currentState;
        this.redoHead = null;
        this.maxHistorySize = maxHistorySize;
        this.historySize = 1;
    }

    // Add new state after an action
    public void addState(String content) {
        if (historySize >= maxHistorySize) {
            removeOldestState();
        }
        TextNode newNode = new TextNode(content);
        undoHead.next = newNode;
        newNode.prev = undoHead;
        undoHead = newNode;
        redoHead = null;  // Clear redo history after new action
        historySize++;
    }

    // Remove the oldest state if history exceeds max size
    private void removeOldestState() {
        if (undoHead.prev != null) {
            undoHead = undoHead.prev;
            undoHead.next = null;
            historySize--;
        }
    }

    // Undo the last action
    public void undo() {
        if (undoHead.prev != null) {
            redoHead = undoHead;
            undoHead = undoHead.prev;
            System.out.println("Undo: " + undoHead.content);
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    // Redo the last undone action
    public void redo() {
        if (redoHead != null) {
            System.out.println("Redo: " + redoHead.content);
            undoHead = redoHead;
            redoHead = redoHead.next;
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        System.out.println("Current state: " + undoHead.content);
    }
}
