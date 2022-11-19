package JavaSE.com.Collection.list.linkedlist.MyLinkedList;

public class Node {
    private  Node previous;
    private  Object value;
    private Node next;

    public Node(Node previous, Object value, Node next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public Node() {
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
