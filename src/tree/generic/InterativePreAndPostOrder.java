package tree.generic;

import stack.stackArray.Stack;

public class InterativePreAndPostOrder {


    static int maxDiameter = 0;

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

        printPreAndPostOrder(tree.root);

//        System.out.println(maxDiameter);


    }

    public static <T> void printPreAndPostOrder(Node<T> node) {
        Stack<Pair<Integer>> stack = new Stack<>();
        stack.push(Pair.of(node, -1));
        String preOrderResult = "PRE ";
        String postOrderResult = "POST ";


        while (stack.size() != 0) {
            Pair<Integer> peekValue = stack.peek();
            if (peekValue.state == -1) {
                preOrderResult = preOrderResult + peekValue.node.data + " ";
                peekValue.state += 1;
            } else if (peekValue.state > -1) {
                if (peekValue.node.childs.size() > peekValue.state) {
                    stack.push(Pair.of(peekValue.node.childs.get(peekValue.state), -1));
                    peekValue.state += 1;
                } else if (peekValue.node.childs.size() == peekValue.state) {
                    postOrderResult = postOrderResult + peekValue.node.data + " ";
                    stack.pop();
                }
            }
        }
        System.out.println(preOrderResult);
        System.out.println(postOrderResult);

    }

    static class Pair<T> {
        Node<T> node;
        Integer state;

        public Pair(Node<T> node, Integer state) {
            this.node = node;
            this.state = state;
        }

        public static <T> Pair of(Node<T> node, Integer state) {
            Pair<T> pair = new Pair<>(node, state);
            return pair;
        }

    }


}
