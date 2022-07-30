package linkedList.singlyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SinglyList<Integer> list = new CircularSinglyLinkedList<>();
        list.add(10);
        list.add(15);
        list.add(17);
        list.add(11);
        list.add(31);
        list.traverse();

        list.reverse();
//        list.deleteFirst(11);
        System.out.println();

        list.traverse();
    }
}
