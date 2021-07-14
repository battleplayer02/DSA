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
public class Sort012_Pointer {

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {

        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode d0 = new ListNode(0), d1 = new ListNode(0), d2 = new ListNode(0);
        ListNode c0 = d0, c1 = d1, c2 = d2;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 1) {
                c1.next = curr;
                c1 = c1.next;
            } else if (curr.val == 0) {
                c0.next = curr;
                c0 = c0.next;
            } else {
                c2.next = curr;
                c2 = c2.next;
            }
            curr = curr.next;
        }
        if (d1.next != null) {
            c0.next = d1.next;
        }
        if (d2.next != null) {
            c1.next = d2.next;
        }
        if (d0.next == null) {
            return d1.next;
        }
        if (d1.next == null) {
            return null;
        }
        c2.next = null;
        return d0.next;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
