package tree.generic;

public class MultiSolver {

    public static int minValue = Integer.MAX_VALUE;
    public static int maxValue = Integer.MIN_VALUE;
    public static int height = 0;
    public static int size = 0;
    public static Node<Integer> successorNode;
    public static Node<Integer> predecessorNode;
    public static int state = 0;

    public static Integer ceilValue = Integer.MAX_VALUE;

    public static Integer floorValue = Integer.MIN_VALUE;
    public static Node<Integer> maxRoot;
    public static Integer maxRootSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

        multiSolver(tree.root, 0);
        System.out.println("maxValue " + maxValue);
        System.out.println("minValue " + minValue);
        System.out.println("height " + height);
        System.out.println("size " + size);

    }

    public static void multiSolver(Node<Integer> root, Integer depth) {
        size++;
        if (root.data > maxValue) {
            maxValue = root.data;
        }
        if (root.data < minValue) {
            minValue = root.data;
        }
        height = Integer.max(depth, height);

        for (Node node : root.childs) {
            multiSolver(node, depth + 1);
        }
    }

    public static void setSuccessorAndPredecessor(Node<Integer> root, Integer node) {
        if (state == 0) {
            if (root.data.equals(node)) {
                state = 1;
            } else {
                predecessorNode = root;
            }
        } else if (state == 1) {
            successorNode = root;
            state = 2;
        }
        for (Node<Integer> theNode : root.childs) {
            setSuccessorAndPredecessor(theNode, node);
        }
    }

    public static void ceilAndFloorValue(Node<Integer> root, Integer node) {
        if (root.data < node && root.data > floorValue) {
            floorValue = root.data;
        }
        if (root.data > node && root.data < ceilValue) {
            ceilValue = root.data;
        }

        for (Node<Integer> theNode : root.childs) {
            ceilAndFloorValue(theNode, node);
        }
    }

    public static void kThLargestElement(Node<Integer> root, int k) {
        floorValue = Integer.MIN_VALUE;
        Integer factor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloorValue(root, factor);
            factor = floorValue;
            floorValue = Integer.MIN_VALUE;
        }
    }

    public static Integer nodeWithMaxSubTreeSum(Node<Integer> root) {
        int sum = 0;

        for (Node<Integer> theNode : root.childs) {
            Integer sumSoFar = nodeWithMaxSubTreeSum(theNode);
            sum += sumSoFar;
        }

        sum += root.data;

        if (sum > maxRootSum) {
            maxRootSum = sum;
            maxRoot = root;
        }
        return sum;

    }

}
