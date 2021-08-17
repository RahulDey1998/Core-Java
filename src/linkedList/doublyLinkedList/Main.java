package linkedList.doublyLinkedList;

import linkedList.singlyLinkedList.CircularSinglyLinkedList;
import linkedList.singlyLinkedList.SinglyList;

public class Main {

    public static void main(String[] args) {
        DoublyList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(15);
        list.add(17);
        list.add(11);
        list.add(31);
        list.traverse();
        System.out.println("After reverse");
//        list.reverse();
        list.deleteFirst(11);
        System.out.println();

        list.add(39);
        list.add(20);

        list.traverse();
        System.out.println("Reverse Traverse");
        list.reverseTraverse();
    }
}
