/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL) return 0;
		// 第一次提交时[1,2]算例处报错，没有考虑到只有一个子节点的非叶子节点
        if (root->left != NULL && root->right == NULL) return 1 + minDepth(root->left);
        if (root->left == NULL && root->right != NULL) return 1 + minDepth(root->right); 
        return 1 + min(minDepth(root->left), minDepth(root->right));
    }
};