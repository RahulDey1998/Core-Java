package linkedList.problems;

public class Problem1 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        MyLinkedList linkedList2 = new MyLinkedList();

        linkedList.createLinkedList(7);
        linkedList.insert(1);
        linkedList.insert(6);
        Node node1 = new Node();
        node1.value = 10;
        linkedList.tail.next = node1;
        linkedList.tail = linkedList.tail.next;


        linkedList2.createLinkedList(5);
        linkedList2.insert(9);
        linkedList2.tail.next = linkedList.tail;

        linkedList.insert(11);
        linkedList.insert(12);


//        MyLinkedList sum = linkedList.sum(linkedList, linkedList2);

//        sum.traverse();

//        linkedList.removeDuplicate();
//        linkedList.traverse();
//        linkedList2.traverse();

        System.out.println(MyLinkedList.isIntersect(linkedList,linkedList2));
//        linkedList.returnNthLastElement(4, linkedList.head, new int[] {0});
    }
}
