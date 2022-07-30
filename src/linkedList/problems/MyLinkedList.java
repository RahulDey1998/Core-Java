package linkedList.problems;

import java.util.HashSet;
import java.util.LinkedList;

public class MyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLinkedList(int value) {
        Node node = new Node();
        node.value = value;
        node.next=null;
        head = node;
        tail = node;
        size = 1;
    }

    public void insert(int value) {
        if(head == null) {
            createLinkedList(value);
            return;
        }
        Node node = new Node();
        node.value = value;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void traverse() {
        Node temp = head;
        System.out.println();
        while(temp != null) {
           System.out.print(temp.value +" -> ");
           temp = temp.next;
        }
    }

    public void removeDuplicate() {
        HashSet set = new HashSet();
        Node temp = head;
        Node prev = new Node();
        while(temp != null) {
           if(set.contains(temp.value)) {
             prev.next = temp.next;
             prev = prev;
             size--;
           }
           else {
               set.add(temp.value);
               prev = temp;
           }
           temp = temp.next;
        }
    }

    public void returnNthLastElement(int n, Node head, int[] arr) {
        if(head == null) {
            return;
        }
         returnNthLastElement(n, head.next, arr);
         arr[0]++;
         if(arr[0] == n) {
           System.out.println(head.value);
           return;
         }
    }

    public MyLinkedList sum(MyLinkedList list1, MyLinkedList list2) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        int carry = 0;
        MyLinkedList resultList = new MyLinkedList();
        while (head1 != null || head2 != null) {
            int result = carry;
            if (head1 != null) {
                result += head1.value;
                head1 = head1.next;
            }
             if(head2 != null) {
                result += head2.value;
                head2 = head2.next;
            }

            carry = result / 10;
            result = result % 10;
            resultList.insert(result);
        }
        if(carry != 0) {
            resultList.insert(carry);
        }
        return resultList;
    }

    public static boolean isIntersect(MyLinkedList list1, MyLinkedList list2) {
        int size1 =0;
        int size2 = 0;
        Node head1 = list1.head;
        Node head2 = list2.head;


        while(head1 != null){
            size1 ++;
            head1 = head1.next;
        }
        while(head2 != null){
            size2 ++;
            head2 = head2.next;
        }
        head1 = list1.head;
        head2 = list2.head;


        if(size1 - size2 > 0) {
            for(int i = 0 ; i < size1 - size2; i++){
                head1 = head1.next;
            }
        }
        else if(size2 - size1 > 0) {
            for(int i = 0 ; i < size2 - size1; i++){
                head2 = head2.next;
            }
        }

        while(head1 != null & head2!= null){
            if(head1.next == head2.next){
                System.out.println("Intersection Node : - " + head1.next);
                return true;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return false;
    }
}
