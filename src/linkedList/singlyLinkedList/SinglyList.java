package linkedList.singlyLinkedList;

public interface SinglyList<T>{
    public void add(T t);
    public T get(T t);
    public T deleteFirst(T t);
    public T deleteAll(T t);
    public boolean contains(T t);
    public Node<T> reverse();
    public void traverse();
}
