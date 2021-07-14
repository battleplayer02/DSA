/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList_Level_2;

import java.util.*;

/**
 *
 * @author Administrator
 * 
 */
public class Merge_Sort_LL {

static class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode mid = midNode(head);
    ListNode p1 = head;
    ListNode p2 = mid.next;

    mid.next = null;

    return mergeTwoLists(mergeSort(p1), mergeSort(p2));
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode t1 = l1, t2 = l2;
    ListNode res = new ListNode(0);
    ListNode HresH = res;
    while (t1 != null && t2 != null) {
      if (t1.val < t2.val) {
        res.next = t1;
        t1 = t1.next;
      } else {
        res.next = t2;
        t2 = t2.next;
      }
      res = res.next;
    }

    if (t1 != null) {
      res.next = t1;
      t1 = t1.next;
    }

    if (t2 != null) {
      res.next = t2;
      t2 = t2.next;
    }
    return HresH.next;
  }

  public static ListNode midNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode s = head;
    ListNode f = head;

    while (f.next != null && f.next.next != null) {
      f = f.next;
      f = f.next;
      s = s.next;
    }
    return s;
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

    ListNode head = mergeSort(h1);
    printList(head);
  }
}
}
