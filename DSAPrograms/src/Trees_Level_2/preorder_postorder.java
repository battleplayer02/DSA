package Trees_Level_2;

import java.util.Scanner;

public class preorder_postorder {

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length != post.length) {
            return null;
        }
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public static TreeNode buildTree(int[] pre, int startPre, int endPre, int[] post, int startPost, int endPost) {
        if (startPre > endPre || startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        if (startPre == endPre)
            return root;
        int idx = startPost;
        while (idx < endPost && post[idx] != pre[startPre + 1])
            idx++;
        int tle = idx - startPost + 1;
        root.left = buildTree(pre, startPre + 1, startPre + tle, post, startPost, startPost + tle - 1);
        root.right = buildTree(pre, startPre + tle + 1, endPre, post, startPost + tle, endPost);


        return root;
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

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}