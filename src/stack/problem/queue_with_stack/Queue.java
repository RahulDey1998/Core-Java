package stack.problem.queue_with_stack;

import java.util.Stack;

/**
 * @author rahul_dey
 */
public class Queue<T> {

    private Stack<T> enqueStack;
    private Stack<T> dequeStack;

    public Queue() {
        enqueStack = new Stack<>();
        dequeStack = new Stack<>();
    }

    public void enque(T data) {
        enqueStack.push(data);
    }

    public T deque() {
        if (dequeStack.empty() && enqueStack.empty()) {
            throw new UnsupportedOperationException("Queue is empty!");
        }
        if (dequeStack.empty()) {
            while (!enqueStack.empty()){
                dequeStack.push(enqueStack.pop());
            }
        }
        return dequeStack.pop();
    }

}
