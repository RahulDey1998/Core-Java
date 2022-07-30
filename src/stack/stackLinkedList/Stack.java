package stack.stackLinkedList;

/**
 * @author rahul_dey
 */
public class Stack<T extends Comparable<T>> {

    private Node<T> root;
    private int count;


    // O(1)
    public void push(T newData){
       this.count++;

       if(root == null){
           this.root = new Node<>(newData);
       }
       else {
           Node<T> oldRoot = this.root;
           this.root = new Node<>(newData);
           root.setNextNode(oldRoot);
       }
    }

    public T peek() {
        return root!= null ? root.getData() : null;
    }

    // O(1)
    public T pop() {
        T itemToPop = this.root.getData();
        this.root = this.root.getNextNode();
        count--;
        return itemToPop;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return root == null;
    }

}
