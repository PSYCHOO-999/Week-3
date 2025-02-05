public class TextNode {
    String content;
    TextNode next;
    TextNode prev;

    public TextNode(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}
