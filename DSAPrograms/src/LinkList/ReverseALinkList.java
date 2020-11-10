/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

/**
 *
 * @author Administrator
 */
class Node {

    int data;
    Node next;

    public Node(int n) {
        data = n;
        next = null;
    }

}

public class ReverseALinkList {

    static Node head;

    public static void main(String[] args) {

        ReverseALinkList list = new ReverseALinkList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        System.out.println("Given Linked list");
        list.display();
        head = list.reverseIteration(head);
        System.out.println("");
        System.out.println("Reversed linked list Iteration");
        list.display();
        head = list.reverseRecurssion(head);
        System.out.println("");
        System.out.println("Reversed linked list Recurssion");
        list.display();
    }

    Node reverseIteration(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    static private void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }
    public static Node reverseRecurssion(Node head) 
    { 
        if (head == null || head.next == null) 
            return head; 
 
        Node rest = reverseRecurssion(head.next); 
        head.next.next = head; 
        
        head.next = null; 
        return rest; 
    } 
}
