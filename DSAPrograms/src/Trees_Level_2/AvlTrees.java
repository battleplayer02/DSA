package Trees_Level_2;

public class AvlTrees {

    public Node insertToAVL(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertToAVL(node.left, data);
        } else if (node.data < data) {
            node.right = insertToAVL(node.right, data);
        }

        int lht = height(node.left), rht = height(node.right);
        node.height = Math.max(lht, rht) + 1;
        int diff = lht - rht;

        Node newRoot = node;
        if (diff > 1) { // left
            if (data < node.left.data) { // LL
                newRoot = rightRotate(node);
            } else if (data > node.left.data) { // LR
                node.left = leftRotate(node.left);
                newRoot = rightRotate(node);
            }
        } else if (diff < -1) { // right
            if (data < node.right.data) { // RL
                node.right = rightRotate(node.right);
                newRoot = leftRotate(node);
            } else if (data > node.right.data) { // RR
                newRoot = leftRotate(node);
            }
        }

        return newRoot;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    public Node leftRotate(Node a) {
        Node b = a.right;
        Node t2 = b.left;

        b.left = a;
        a.right = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public Node rightRotate(Node a) {
        Node b = a.left;
        Node t2 = b.right;

        b.right = a;
        a.left = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

}

// deletion code
class Sol {
    public static Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int max = getMax(root.left);
                root.data = max;

                root.left = deleteNode(root.left, max);
            }
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        Node newRoot = root;
        if (difference(root) > 1) { // L
            int delta = difference(root.left);
            if (delta >= 0) { // LL
                newRoot = rightRotate(root);
            } else if (delta < 0) { // LR
                root.left = leftRotate(root.left);
                newRoot = rightRotate(root);
            }
        } else if (difference(root) < -1) { // R
            int delta = difference(root.right);
            if (delta > 0) { // RL
                root.right = rightRotate(root.right);
                newRoot = leftRotate(root);
            } else if (delta <= 0) { // RR
                newRoot = leftRotate(root);
            }
        }

        return newRoot;
    }

    public static Node leftRotate(Node a) {
        Node b = a.right;
        Node t2 = b.left;

        b.left = a;
        a.right = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public static Node rightRotate(Node a) {
        Node b = a.left;
        Node t2 = b.right;

        b.right = a;
        a.left = t2;

        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int difference(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static int getMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }
}