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
    int maxDepth(TreeNode* root) {
        return (root==NULL)? 0:max(maxDepth(root->left),maxDepth(root->right))+1;
		// 相比之下第一次提交时的代码太挫了
        //if (root == NULL) return 0;	// terminator
        //if (root->left == NULL && root->right == NULL) return 1;	// 这一行就可以递归，因为其下一层包含在终结条件中
		// 一个子节点为空时，其深度为0，故这三行代码可以合并为一行用max表示
        //if (root->left != NULL && root->right == NULL) return  1 + maxDepth(root->left);	
        //if (root->left == NULL && root->right != NULL) return  1 + maxDepth(root->right);	
        //if (root->left != NULL && root->right != NULL) return  1 + max(maxDepth(root->left), maxDepth(root->right));
        //return 0;
    }
};