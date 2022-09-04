package tree.generic;

import java.util.ArrayList;
import java.util.List;

public class RemoveLeafNodes {

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

//        tree.printTree();

//        System.out.println(tree.size(tree.root));
//        System.out.println(tree.max(tree.root));
//        System.out.println(tree.height(tree.root));
//        tree.traverse(tree.root);
//        removeLeafNodes(tree.root);
//        linearizeEfficient(tree.root);
//        tree.printTree();
//        System.out.println(search(tree.root, 300));
        nodeToRootPatch(tree.root, 110).forEach(System.out::println);

    }


    public static <T> void removeLeafNodes(Node<T> root) {
        for (int i = root.childs.size() - 1; i >= 0; i--) {
            Node<T> childNode = root.childs.get(i);
            if (childNode.childs == null || childNode.childs.size() == 0) {
                root.childs.remove(childNode);
            }
        }
        for (Node<T> node : root.childs)
            removeLeafNodes(node);
    }

    public static <T> void linearize(Node<T> root) {
        for (Node<T> node : root.childs) {
            linearize(node);
        }

        while (root.childs.size() > 1) {
            Node<T> lastNode = root.childs.remove(root.childs.size() - 1);
            Node<T> secondLastNode = root.childs.get(root.childs.size() - 1);
            Node<T> tailOfsecondLastNode = getTail(secondLastNode);
            tailOfsecondLastNode.childs.add(lastNode);
        }
    }

    public static <T> boolean search(Node<T> root, T data) {
        if (root.data.equals(data)) {
            return true;
        }
        for (Node<T> node : root.childs) {
            boolean isDataFound = search(node, data);
            if (isDataFound) {
                return true;
            }
        }

        return false;
    }

    public static <T> List<T> nodeToRootPatch(Node<T> root, T data) {
        if (root.data.equals(data)) {
            List<T> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }

        for (Node<T> node : root.childs) {
            List<T> path = nodeToRootPatch(node, data);
            if (path.size() > 0) {
                path.add(0, root.data);
                return path;
            }
        }

        return new ArrayList<>();
    }

    public static <T> Node<T> linearizeEfficient(Node<T> root) {

        if (root.childs.size() == 0) {
            return root;
        }
        Node<T> lastChildNode = linearizeEfficient(root.childs.get(root.childs.size() - 1));

        while (root.childs.size() > 1) {
            Node<T> lastNode = root.childs.remove(root.childs.size() - 1);
            Node<T> secondLastNode = root.childs.get(root.childs.size() - 1);
            Node<T> secondLastNodeLastChild = linearizeEfficient(secondLastNode);
            secondLastNodeLastChild.childs.add(lastNode);
        }
        return lastChildNode;
    }

    private static <T> Node<T> getTail(Node<T> node) {
        if (node.childs.size() == 0) {
            return node;
        } else {
            return getTail(node.childs.get(0));
        }
    }
}
