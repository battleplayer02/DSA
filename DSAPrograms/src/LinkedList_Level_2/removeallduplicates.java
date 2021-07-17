import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode removeDuplicates(ListNode head) {
        // dummy node
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = head.next;
        ListNode itr = dummy;

        itr.next = head;
        while (curr != null) {
            boolean ifdupli = false;
            while (curr != null && itr.next.val == curr.val) {
                ifdupli = true;
                curr = curr.next;
            }
            if (ifdupli) {
                itr.next = curr;
            } else {
                itr = itr.next;
            }
            if (curr != null) {
                curr = curr.next;
            }

        }
        return dummy.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}