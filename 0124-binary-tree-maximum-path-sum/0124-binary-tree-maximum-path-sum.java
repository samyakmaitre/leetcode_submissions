/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Compute the maximum path sum of left and right subtrees
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        // Calculate the current node's value considering both left and right paths
        int currentMax = node.val + leftMax + rightMax;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, currentMax);

        // Return the maximum sum path that can be extended to the parent node
        return node.val + Math.max(leftMax, rightMax);
    }
}