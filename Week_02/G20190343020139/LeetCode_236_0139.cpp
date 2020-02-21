/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * 执行用时 :28 ms, 在所有 cpp 提交中击败了41.08%的用户
 * 内存消耗 :16.8 MB, 在所有 cpp 提交中击败了33.39%的用户
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        //terminator
        if(root == p || root == q || root == NULL) return root;

        //process
        TreeNode* left;
        TreeNode* right;

        //drill down
        left = lowestCommonAncestor(root->left, p, q);
        right = lowestCommonAncestor(root->right,p,q);

        //reverse
        return left == NULL ? right : (right == NULL ? left : root);
    }
};