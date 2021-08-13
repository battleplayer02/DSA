import java.util.*;

class Segregate_over_pivot {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
        if (head == null || head.next == null)
            return head;
        int idx = 0;
        ListNode pivot = head;
        while (pivot != null) {
            if (idx == pivotIdx) {
                break;
            }
            idx++;
            pivot = pivot.next;
        }

        // smaller
        ListNode small = new ListNode(0);
        ListNode smallCurr = small;

        // larger
        ListNode large = new ListNode(0);
        ListNode largerCurr = large;

        // curr
        ListNode curr = head;
        idx = 0;
        while (curr != null) {
            if (idx == pivotIdx) {

            } else if (curr.val <= pivot.val) {
                smallCurr.next = curr;
                smallCurr = smallCurr.next;
            } else {
                largerCurr.next = curr;
                largerCurr = largerCurr.next;
            }
            curr = curr.next;
            idx++;
        }
        smallCurr.next = pivot;
        pivot.next = large.next;
        largerCurr.next = null;
        return small.next;
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
        int idx = scn.nextInt();
        h1 = segregate(h1, idx);
        printList(h1);
    }
}