package Trees_Level_2;

import java.util.*;

public class Segrigate_LinkedList_over_Last_Index {{
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // get last node of a linked list
    public static ListNode getLast(ListNode head) {
        if (head == null)
            return null;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode last = getLast(head);
        // dummy smaller and larger
        ListNode dummySmaller = new ListNode(-1);
        ListNode dummyLarger = new ListNode(-1);

        ListNode smaller = dummySmaller;
        ListNode larger = dummyLarger;

        // current
        ListNode current = head;
        while (current != null) {
            if (current.val < last.val) {
                smaller.next = current;
                smaller = smaller.next;

            } else {
                larger.next = current;
                larger = larger.next;
            }
            current = current.next;
        }
        smaller.next = dummyLarger.next;
        larger.next = null;
        return smaller;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}