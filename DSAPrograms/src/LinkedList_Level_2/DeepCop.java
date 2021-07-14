/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList_Level_2;

/**
 *
 * @author Administrator
 */
import java.util.*;

class DeepCop {

    public static class ListNode {

        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<ListNode, ListNode> hm = new HashMap<>();
        ListNode dummy = new ListNode(0);

        ListNode curr = head,prev = dummy;
        while (curr!=null) {            
            ListNode node = new ListNode(curr.val);
            prev= prev.next;
            curr = curr.next;
        }

        ListNode onode = head,cnode = dummy.next;
        while(onode!=null){
            cnode.random = hm.get(onode.random);
            cnode = cnode.next;
            onode = onode.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null) {
                prev.next = arr[i];
            }
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1) {
                arr[i].random = arr[idx];
            }
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
