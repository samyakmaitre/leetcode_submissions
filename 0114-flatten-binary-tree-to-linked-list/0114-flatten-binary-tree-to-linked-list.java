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
    public void flatten(TreeNode root) {
        if (root == null) // Base case: if root is null, do nothing
            return;
        
        if (root.left != null) {
            // Store the right subtree
            TreeNode rightSubtree = root.right;
            
            // Move the left subtree to the right
            root.right = root.left;
            
            // Set the left subtree to null
            root.left = null;
            
            // Find the rightmost node of the moved left subtree
            TreeNode rightmost = root.right;
            while (rightmost.right != null)
                rightmost = rightmost.right;
            
            // Attach the stored right subtree to the rightmost node
            rightmost.right = rightSubtree;
        }
        
        // Flatten the rest of the tree
        flatten(root.right);
    }
}
