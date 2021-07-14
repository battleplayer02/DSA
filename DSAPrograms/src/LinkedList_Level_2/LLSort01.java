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
public class LLSort01 {

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {

        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        ListNode i = head, j = head, k = head;

        while (i != null) {
            if (i.val == 2) {
                i = i.next;
            } else if (i.val == 1) {
                swap(i, k);
                i = i.next;
                k = k.next;
            } else {
                swap(i, j);
                if (j != k) {
                    swap(i, k);
                }
                i = i.next;
                j = j.next;
                k = k.next;
            }
        }

        return head;
    }

    public static void swap(ListNode i, ListNode j) {
        int t = i.val;
        i.val = j.val;
        j.val = t;
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
