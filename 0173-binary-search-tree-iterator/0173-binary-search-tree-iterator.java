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

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Initialize the stack with the leftmost path from the root
        pushAllLeft(root);
    }
    
    // Returns true if there is a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    // Returns the next smallest number
    public int next() {
        // Pop the top of the stack (smallest element)
        TreeNode node = stack.pop();
        // Push the leftmost path of the right child
        pushAllLeft(node.right);
        return node.val;
    }
    
    // Helper function to push all the left children of a given node onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */