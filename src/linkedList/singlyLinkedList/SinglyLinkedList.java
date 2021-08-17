package linkedList.singlyLinkedList;

public class SinglyLinkedList<T> implements SinglyList<T> {
    private Node head;
    private int size;
    private Node tail;

    public SinglyLinkedList(Node head, int size, Node tail) {
        this.head = head;
        this.size = size;
        this.tail = tail;
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public SinglyLinkedList(){}

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
            this.size++;
        }
        else {
            Node<T> node = new Node();
            node.setValue(t);
            node.setNext(null);
            this.tail.setNext(node);
            tail = node;
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
            while (current != null) {
                if(current.getValue() == t) {
                   prev.setNext(current.getNext());
                   return t;
                }
                else {
                    prev = current;
                    current = current.getNext();
                }
            }
        }
        return null;

    }

    @Override
    public T deleteAll(T t) {
        return null;
    }

    @Override
    public boolean contains(T t) {
        Node tempHead = head;
        while(tempHead != null) {
            if(tempHead.getValue() == t) {
                return true;
            }
            tempHead = tempHead.getNext();
        }
        return false;
    }

    @Override
    public Node<T> reverse() {
       Node<T> current = this.head; //1-2-3-4-5-6-7
       Node<T> prev = null;
       Node<T> next = null;

       while (current != null) {
          next = current.getNext();
          current.setNext(prev);
          prev = current;
          current = next;
       }
       this.head = prev;
       return prev;
    }

    @Override
    public void traverse() {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getNext();
        }
    }
}
