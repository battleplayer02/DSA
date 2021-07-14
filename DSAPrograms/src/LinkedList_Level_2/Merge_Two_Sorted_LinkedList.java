/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList_Level_2;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Merge_Two_Sorted_LinkedList {

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {

        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(
            ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode d = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while (l1 != null) {
            l3 = l1;
            l1 = l1.next;
            l3 = l3.next;
        }
        while (l2 != null) {
            l3 = l2;
            l1 = l2.next;
            l3 = l3.next;
        }

        return d.next;
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
        int m = scn.nextInt();
        ListNode h2 = createList(m);

        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}
