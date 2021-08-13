package Trees_Level_2;

import java.util.Scanner;

public class inorder_postorder {

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei) {
        if (isi > iei || psi > pei)
            return null;

        TreeNode root = new TreeNode(postorder[pei]);
        int i = isi;
        while (i <= iei && inorder[i] != postorder[pei])
            i++;
        int j = i - isi;
        root.left = buildTree(inorder, isi, i - 1, postorder, psi, psi + j - 1);
        root.right = buildTree(inorder, i + 1, iei, postorder, psi + j, pei - 1);
        return root;
    }

    public static TreeNode buildTree(int preorder[], int psi, int pei, int inorder[], int isi, int iei) {
        if (psi > pei)
            return null;
        int val = preorder[psi];
        int idx = isi;
        while (inorder[idx] != val) {
            idx++;
        }
        int tnel = idx - isi;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);

        node.right = buildTree(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);
        return node;
    }
    // input_section=================================================

    public static void display(TreeNode node) {
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

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}