package tree.generic;

import java.util.*;

class Pair<K, V> {
    Node<K> node;
    V level;

    Pair(K k, V v) {
        this.node = new Node<>(k);
        this.level = v;
    }

    static <K, V> Pair<K, V> instance(K k, V v) {
        return new Pair<>(k, v);
    }
}

public class GenericTreeConstructing {

    public static void main(String[] args) {
        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

//        tree.printTree();

//        System.out.println(tree.size(tree.root));
//        System.out.println(tree.max(tree.root));
//        System.out.println(tree.height(tree.root));
//        tree.traverse(tree.root);
        tree.levelOrderLineWise2(tree.root);

    }

}

class GenericTree<T> {
    Node<T> root;
    Stack<Node<T>> stack = new Stack<>();

    public GenericTree(Object[] dataArray) {
        T[] arr = (T[]) dataArray;
        for (T data : arr) {
            if (convertToInt(data) == -1) {
                stack.pop();
            } else {
                Node node = new Node(data);
                if (stack.isEmpty()) {
                    root = node;
                } else {
                    stack.peek().childs.add(node);
                }
                stack.push(node);
            }
        }
    }

    public void printTree() {
//        System.out.println(root.data);
        printChilds(root);
    }

    private void printChilds(Node<T> root) {
        if (root == null) {
            return;
        }
        String data = root.data + " -> ";
        if (root.childs != null) {
            for (Node<T> node : root.childs) {
                data = data.concat(node.data + ", ");
            }
            data = data.substring(0, data.length() - 2).concat(".");
            System.out.println(data);
            for (Node<T> node : root.childs) {
                printChilds(node);
            }
        }
    }

    public int size(Node<T> root) {
        if (root == null) {
            return -1;
        }
        int sizeSoFar = 0;
        for (Node<T> node : root.childs) {
            sizeSoFar += size(node);
        }
        return sizeSoFar + 1;
    }

    public int max(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int maxSoFar = Integer.MIN_VALUE;
        for (Node<T> node : root.childs) {
            int max = max(node);
            if (max > maxSoFar) {
                maxSoFar = max;
            }
        }
        return Math.max(maxSoFar, (Integer) root.data);
    }

    public void traverse(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.println("Node pre - " + root.data);
        for (Node<T> node : root.childs) {
            System.out.println("Edge pre - " + root.data + "--" + node.data);
            traverse(node);
            System.out.println("Edge post - " + root.data + "--" + node.data);
        }
        System.out.println("Node post - " + root.data);
    }

    public void levelOrder(Node<T> root) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(root);
        T tempVal = null;
        while (queue.size() > 0) {
            Node<T> node = queue.remove();
            System.out.print(node.data + " ");
            if (tempVal == null || Objects.equals(tempVal, node.data)) {
                System.out.println();
            }

            T temp = null;
            for (Node<T> child : node.childs) {
                queue.add(child);
                temp = child.data;
            }
            if (tempVal == null || node.data.equals(tempVal)) {
                tempVal = temp;
            }
        }

        System.out.println(".");
    }

    public void levelOrderLineWise(Node<T> root) {
        Queue<Node<T>> mainQueue = new LinkedList<>();
        Queue<Node<T>> childQueue = new LinkedList<>();
        mainQueue.add(root);
        while (mainQueue.size() > 0 || childQueue.size() > 0) {
            Node<T> node = null;
            if (mainQueue.size() > 0) {
                node = mainQueue.remove();
                System.out.print(node.data + " ");

                for (Node<T> child : node.childs) {
                    childQueue.add(child);
                }
            } else {
                System.out.println();

                while (childQueue.size() > 0) {
                    mainQueue.add(childQueue.remove());
                }
            }
        }
        System.out.println(".");
    }

    public void levelOrderLineWise1(Node<T> root) {
        Queue<Node<T>> mainQueue = new LinkedList<>();
        mainQueue.add(root);
        mainQueue.add(null);
        while (mainQueue.size() > 0) {
            Node<T> node = null;

            node = mainQueue.remove();
            if (node != null) {
                System.out.print(node.data + " ");

                for (Node<T> child : node.childs) {
                    mainQueue.add(child);
                }
            } else {
                if (mainQueue.size() == 0) {
                    return;
                }
                mainQueue.add(null);
                System.out.println();
            }
        }
        System.out.println(".");
    }

    public void levelOrderLineWise2(Node<T> root) {
        Queue<Node<T>> mainQueue = new LinkedList<>();
        mainQueue.add(root);

        Node<T> node = null;

        while (mainQueue.size() > 0) {
            int size = mainQueue.size();
            for (int i = 0; i < size; i++) {
                node = mainQueue.remove();
                System.out.print(node.data + " ");
                for (Node<T> child : node.childs) {
                    mainQueue.add(child);
                }
            }
            System.out.println();
        }

        System.out.println(".");
    }

    public void levelOrderLineWise3(Node<T> root) {
        Queue<Pair<Node<T>, Integer>> mainQueue = new LinkedList<>();
        mainQueue.add(Pair.instance(root, 1));

        Node<T> node = null;
        int level = 1;

        while (mainQueue.size() > 0) {
            Pair<Node<T>, Integer> nodeToRemove = mainQueue.remove();
            if (nodeToRemove.level > level) {
                level = nodeToRemove.level;
                System.out.println();
            }
            for (Node<T> child : node.childs) {
                mainQueue.add(Pair.instance(child, level + 1));
            }
        }
    }

    public void levelOrderLineWiseZigZag(Node<T> root) {
        Stack<Node<T>> mainStack = new Stack<>();
        Stack<Node<T>> childStack = new Stack<>();
        mainStack.push(root);
        int iterationNo = 1;
        while (mainStack.size() > 0) {
            Node<T> node = null;
            node = mainStack.pop();
            System.out.print(node.data + " ");

            if (iterationNo % 2 == 0) {
                for (int i = node.childs.size() - 1; i >= 0; i--) {
                    childStack.push(node.childs.get(i));
                }
            } else {
                for (int i = 0; i < node.childs.size(); i++) {
                    childStack.push(node.childs.get(i));
                }
            }
            if (mainStack.size() == 0) {
                mainStack = childStack;
                childStack = new Stack<>();
                iterationNo++;
                System.out.println();
            }
        }
        System.out.println(".");
    }

    public int height(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int heightSoFar = 0;
        for (Node<T> node : root.childs) {
            int height = height(node);
            if (height > heightSoFar) {
                heightSoFar = height;
            }
        }
        return heightSoFar + 1;
    }

    private int convertToInt(T data) {
        int result = (int) data;
        return result;
    }

}

class Node<T> {
    T data;
    List<Node<T>> childs;

    public Node(T data) {
        this.data = data;
        childs = new ArrayList<>();
    }
}


