package linkedList.singlyLinkedList;

public class CircularSinglyLinkedList<T> implements SinglyList<T> {
    private Node head;
    private int size;
    private Node tail;

    public CircularSinglyLinkedList(Node head, int size, Node tail) {
        this.head = head;
        this.size = size;
        this.tail = tail;
    }

    public CircularSinglyLinkedList(Node head) {
        this.head = head;
    }

    public CircularSinglyLinkedList(){}

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public void add(T t) {
        if(this.head == null) {
            Node<T> node = new Node();
            node.setValue(t);
            node.setNext(null);
            this.head = node;
            this.tail = node;
            tail.setNext(this.head);
            this.size++;
        }
        else {
            Node<T> node = new Node();
            node.setValue(t);
            node.setNext(null);
            this.tail.setNext(node);
            this.tail = node;
            this.tail.setNext(this.head);
            size++;
        }
    }

    @Override
    public T get(T t) {
      return null;
    }

    @Override
    public T deleteFirst(T t) {
        Node current = head.getNext();
        Node prev = head;
        if(head.getValue() == t) {
            head.setNext(null);
            head = head.getNext();
        }
        else {
            do {
                if(current.getValue() == t) {
                   prev.setNext(current.getNext());
                   size--;
                   return t;
                }
                else {
                    prev = current;
                    current = current.getNext();
                }
            }
            while (current != head) ;
        }
        return null;

    }

    @Override
    public T deleteAll(T t) {
        return null;
    }

    @Override
    public boolean contains(T t) {
        Node tempHead = this.head;
        do {
            if(tempHead.getValue() == t) {
                return true;
            }
            tempHead = tempHead.getNext();
        }
        while(tempHead != this.head);
        return false;
    }

    @Override
    public Node<T> reverse() {
       Node<T> current = this.head; //1-2-3-4-5-6-7
       Node<T> prev = null;
       Node<T> next = null;
       Node<T> tailRef = this.head;
       do {
           next = current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
       }
       while (current != this.head);
       this.head = prev;
       tailRef.setNext(this.head);
       return prev;
    }

    @Override
    public void traverse() {
        Node tempNode = head;
        do {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNext();
        }
        while(tempNode != this.head);
    }
}
