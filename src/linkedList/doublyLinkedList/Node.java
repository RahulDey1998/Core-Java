package linkedList.doublyLinkedList;

public class Node<T> {
    private T value;
    private Node next;
    private Node prev;

    public Node(T value, Node next, Node prev) {
        this.value = value;
        this.prev= prev;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public Node() {}

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
