package stack.problem.queue_with_stack;

import java.util.Stack;

/**
 * @author rahul_dey
 */
public class SingleStackQueue<T> {

    private Stack<T> stack;

    public SingleStackQueue() {
        stack = new Stack();
    }

    public void enque(T data){
        this.stack.push(data);
    }

    public T deque(){
        if(stack.empty()){
            throw new UnsupportedOperationException("Queue is empty!");
        }
        if (stack.size() == 1){
            return stack.pop();
        }

        T item = stack.pop();
        System.out.println("pop - " + item);

        T lastDequeItem = deque();
        System.out.println("last deque" + lastDequeItem);

        enque(item);
        System.out.println("enque - " + item);

        return lastDequeItem;
    }
}
