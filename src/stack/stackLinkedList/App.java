package stack.stackLinkedList;

/**
 * @author rahul_dey
 */
public class App {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(100);
        myStack.push(150);
        myStack.push(200);

        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());

    }
}
