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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> pot = new ArrayList<>();
    if (root == null) {
        return pot;
    }
    pot.addAll(postorderTraversal(root.left));
    pot.addAll(postorderTraversal(root.right));
    pot.add(root.val);

    return pot;
}
}