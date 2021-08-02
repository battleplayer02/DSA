package Trees_Level_2;

public class dll_to_btree {

    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        if (head == null || head.right == null)
            return head;
        Node root = mid(head);
        Node bck = root.left;
        Node fwd = root.right;
        if (bck != null)
            root.left = bck.right = null;
        root.right = fwd.left = null;

        root.left = SortedDLLToBST(bck == null ? null : head);
        root.right = SortedDLLToBST(fwd);
        return root;
    }

    // get mid node
    public static Node mid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    // Input_code===================================================

    public static void display(Node node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            Node node = new Node(scn.nextInt());
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }

        Node head = dummy.right;
        head.left = dummy.right = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = makeList(scn.nextInt());

        head = SortedDLLToBST(head);
        display(head);
    }

}