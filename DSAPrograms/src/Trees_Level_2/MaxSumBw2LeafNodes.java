package Trees_Level_2;

import java.util.Scanner;

public class MaxSumBw2LeafNodes {

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int ltlmaxsum = 0;

    public static int maxPathSum(TreeNode root) {
        ltlmaxsum = 0;
        maxPathSumHelper(root);
        return ltlmaxsum;
    }

    public static int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = maxPathSumHelper(root.left);
        int rightsum = maxPathSumHelper(root.right);
        if (root.left != null && root.right != null)
            ltlmaxsum = Math.max(ltlmaxsum, leftsum + rightsum + root.val);

        return Math.max(leftsum, rightsum) + root.val;
    }

    // input_Section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
