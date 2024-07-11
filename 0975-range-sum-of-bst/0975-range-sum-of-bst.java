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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Base case: if the current node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // If the current node's value is less than low, we only need to consider the right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // If the current node's value is greater than high, we only need to consider the left subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // If the current node's value is within the range [low, high], include its value in the sum
        // and consider both subtrees
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
