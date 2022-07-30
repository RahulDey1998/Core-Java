package stack.problem.queue_with_stack;

/**
 * @author rahul_dey
 */
public class App {

    public static void main(String[] args) {

        SingleStackQueue<Integer> queue = new SingleStackQueue<>();

        queue.enque(10);
        queue.enque(15);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.enque(45);

        System.out.println(queue.deque());
//        System.out.println(queue.deque());
    }

}
