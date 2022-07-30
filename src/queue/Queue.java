package queue;

/**
 * @author rahul_dey
 */
public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public void enqueue(T data) {
        count++;
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(data);
        this.lastNode.setNextNode(null);

        if (isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty!");
        }
        T data = this.lastNode.getData();
        this.lastNode = this.lastNode.getNextNode();

        if(isEmpty()){
            this.lastNode = null;
        }
        count--;
        return data;
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

}
