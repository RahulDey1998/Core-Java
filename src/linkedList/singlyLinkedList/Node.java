package linkedList.singlyLinkedList;

public class Node<T> {
    private T value;
    private Node next;

    public Node(T value, Node next) {
        this.value = value;
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
}
