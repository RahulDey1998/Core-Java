package tree.generic;

import java.util.ArrayList;
import java.util.List;

public class MirrorOfTree {

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

//        tree.printTree();

//        System.out.println(tree.size(tree.root));
//        System.out.println(tree.max(tree.root));
//        System.out.println(tree.height(tree.root));
//        tree.traverse(tree.root);
        mirror(tree.root);
        tree.levelOrderLineWise1(tree.root);

    }


    public static <T> void mirror(Node<T> root) {

        if (root.childs != null && root.childs.size() > 1) {
            List<Node<T>> newChilds = new ArrayList<>();
            for (int i = root.childs.size() - 1; i >= 0; i--) {
                newChilds.add(root.childs.get(i));
            }

            root.childs = newChilds;

            for (Node node : root.childs) {
                mirror(node);
            }
        }

    }


}
