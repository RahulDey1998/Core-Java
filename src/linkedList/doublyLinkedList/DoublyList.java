package linkedList.doublyLinkedList;

import linkedList.doublyLinkedList.Node;

public interface DoublyList<T>{
    public void add(T t);
    public T get(T t);
    public T deleteFirst(T t);
    public T deleteAll(T t);
    public boolean contains(T t);
    public Node<T> reverse();
    public void traverse();
    public void reverseTraverse();
}
