package tree.generic;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestors {

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

        Integer[] array2 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, 130, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree2 = new GenericTree<>(array2);

//        tree.printTree();

//        System.out.println(tree.size(tree.root));
//        System.out.println(tree.max(tree.root));
//        System.out.println(tree.height(tree.root));
//        tree.traverse(tree.root);
//        removeLeafNodes(tree.root);
//        linearizeEfficient(tree.root);
//        tree.printTree();
//        System.out.println(search(tree.root, 300));
//        nodeToRootPatch(tree.root, 110).forEach(System.out::println);

        System.out.println(isTreeSimilarInShape(tree.root, tree2.root));
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

    public static <T> T getLowestCommonAncestor(Node<T> root, T data1, T data2) {
        List<T> path1 = nodeToRootPatch(root, data1);
        List<T> path2 = nodeToRootPatch(root, data2);

        int i = 0;
        int j = 0;

        while (i < path1.size() && j < path2.size() && path1.get(i).equals(path2.get(i))) {
            i++;
            j++;
        }
        i--;
        j--;

        return path1.get(i);
    }

    public static <T> int getDistanceBetWeenTwoNode(Node<T> root, T node1, T node2) {
        List<T> path1 = nodeToRootPatch(root, node1);
        List<T> path2 = nodeToRootPatch(root, node2);

        int i = 0;
        int j = 0;

        while (i < path1.size() && j < path2.size() && path1.get(i).equals(path2.get(i))) {
            i++;
            j++;
        }
        i--;
        j--;


        return (path1.size() - i) + (path2.size() - j);
    }

    public static <T> boolean isTreeSimilarInShape(Node<T> root1, Node<T> root2) {
        if (root1.childs.size() != root2.childs.size()) {
            return false;
        }

        for (int i = 0; i < root1.childs.size(); i++) {
            Node<T> child1 = root1.childs.get(i);
            Node<T> child2 = root2.childs.get(i);
            if (isTreeSimilarInShape(child1, child2) == false) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isTreeMirrorOfEachOther(Node<T> root1, Node<T> root2) {
        if (root1.childs.size() != root2.childs.size()) {
            return false;
        }

        for (int i = 0; i < root1.childs.size(); i++) {
            int j = root2.childs.size() - 1 - i;
            Node<T> child1 = root1.childs.get(i);
            Node<T> child2 = root2.childs.get(j);
            if (isTreeMirrorOfEachOther(child1, child2) == false) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isTreeSymmetric(Node<T> root) {
        if (isTreeMirrorOfEachOther(root, root)) {
            return true;
        } else {
            return false;
        }
    }


}
