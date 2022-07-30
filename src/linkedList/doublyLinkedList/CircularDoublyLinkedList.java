package linkedList.doublyLinkedList;

public class CircularDoublyLinkedList<T> implements DoublyList<T> {
    private Node head;
    private int size;
    private Node tail;

    public CircularDoublyLinkedList(Node head, int size, Node tail) {
        this.head = head;
        this.size = size;
        this.tail = tail;
    }

    public CircularDoublyLinkedList(Node head) {
        this.head = head;
    }

    public CircularDoublyLinkedList(){}

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
            node.setPrev(null);
            this.head = node;
            this.tail = node;
            this.tail.setNext(this.head);
            this.head.setPrev(this.tail);
            this.size++;
        }
        else {
            Node<T> node = new Node();
            node.setValue(t);
            node.setNext(null);
            node.setPrev(this.tail);
            this.tail.setNext(node);
            this.tail = node;
            this.tail.setNext(this.head);
            this.head.setPrev(this.tail);
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
            head.setPrev(this.tail);
            this.tail.setPrev(this.head);
        }
        else {
            do {
                if(current.getValue() == t) {
                    prev.setNext(current.getNext());
                    current.getNext().setPrev(prev);
                    size--;
                    return t;
                }
                else {
                    prev = current;
                    current = current.getNext();
                }
            }
            while (current != this.head) ;
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
       Node<T> current =  this.head; //1-2-3-4-5-6-7
       Node<T> prev = null;
       Node<T> next = null;

       while (current != null) {
          next = current.getNext();
          current.setNext(prev);
          if(prev != null) {
              prev.setPrev(current);
          }
          prev = current;
          current = next;
       }
       prev.setPrev(null);
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

    @Override
    public void reverseTraverse() {
        Node tempNode = tail;
        while(tempNode != null) {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.getPrev();
        }
    }
}
