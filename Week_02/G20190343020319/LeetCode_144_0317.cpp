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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> vOut;
        preorderTraversal( root, &vOut);
		return vOut;
    }

     void preorderTraversal(TreeNode* root,  vector<int>* out) {
		if (NULL == root)
		{
			return;
		}
		
		//visit the root 
		out->push_back(root->val);

		//Traversa the left subtree
		preorderTraversal(root->left, out);

		//traversa the right subtree
		preorderTraversal(root->right, out);
		return;
    }
};