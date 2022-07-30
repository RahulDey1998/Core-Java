package stack.stackArray;

/**
 * @author rahul_dey
 */
public class App {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>(2);

        myStack.push(100);
        myStack.push(150);
        myStack.push(200);
        myStack.push(250);
        myStack.push(300);
        myStack.push(350);
        myStack.push(400);

        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.peek());


    }
}
