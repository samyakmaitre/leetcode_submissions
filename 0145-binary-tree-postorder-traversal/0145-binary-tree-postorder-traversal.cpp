/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> stk;
        TreeNode* prev = nullptr;

        while (root != nullptr || !stk.empty()) {
            while (root != nullptr) {
                stk.push(root);
                root = root->left;
            }
            root = stk.top(); stk.pop();
            if (root->right == nullptr || root->right == prev) {
                // If the right subtree is empty or has been visited
                result.push_back(root->val);
                prev = root;
                root = nullptr;
            } else {
                // If the right subtree hasn't been visited yet
                stk.push(root);
                root = root->right;
            }
        }

        return result;
    }
};