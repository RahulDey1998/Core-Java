package stack.stackArray;

/**
 * @author rahul_dey
 */
public class Stack<T extends Object> {

    public final int DEFAULT_CAPACTITY = 10;
    T[] stack;
    int currentIndex;

    public Stack() {
        stack = (T[]) new Object[DEFAULT_CAPACTITY];
        currentIndex = 0;
    }

    public Stack(int capacity) {
        stack = (T[]) new Object[capacity];
        currentIndex = 0;
    }

    public void push(T data) {
        if (currentIndex == stack.length) {
            resize(currentIndex * 2);
        }
        stack[currentIndex++] = data;
    }

    public T pop(){
        if(currentIndex > 0){
            if(currentIndex == stack.length /4) {
                resize(stack.length / 2);
            }
           return stack[--currentIndex];
        }
        else {
            throw new UnsupportedOperationException("Can not pop from empty stack.");
        }
    }

    public T peek(){
        if(currentIndex > 0){
            return stack[currentIndex-1];
        }
        else {
            throw new UnsupportedOperationException("Can not peek from empty stack.");
        }
    }

    public int size() {
        return currentIndex;
    }

    private void resize(int newLength) {
        System.out.println("LOG - resizing array to new length : " + newLength);
        T[] newStack = (T[]) new Object[newLength];
        System.arraycopy(stack, 0, newStack, 0, currentIndex);
        stack = newStack;
    }

}
