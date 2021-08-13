package DoubleyLinkedList;

//import util *
import java.util.*;

public class AddFirst {
    public static class DoublyLinkedList {
        private class Node {
            private int data = 0;
            private Node prev = null;
            private Node next = null;

            Node(int data) {
                this.data = data;
                prev = next = null;
            }

        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = this.head;
            sb.append("[");
            while (curr != null) {
                sb.append(curr.data);
                if (curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            sb.append("]");

            return sb.toString();
        }

        public void addFirst(int val) {
            if (size == 0) {
                head = tail = new Node(val);
                size++;
            } else {
                Node newHead = new Node(val);
                newHead.next = head;
                head.prev = newHead;
                head = newHead;
                size++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        String str = scn.nextLine();
        while (!str.equals("stop")) {
            String[] s = str.split(" ");
            if (s[0].equals("addFirst"))
                dll.addFirst(Integer.parseInt(s[1]));

            str = scn.nextLine();
        }
        System.out.println(dll);
    }
}