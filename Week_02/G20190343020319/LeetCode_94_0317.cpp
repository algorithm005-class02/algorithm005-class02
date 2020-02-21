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
    vector<int> inorderTraversal(TreeNode* root) {
     vector<int> vOut;
		vector<TreeNode*> vTreeNode;
		TreeNode* curNode = root;
		while (NULL != curNode )
		{
			if (NULL != curNode->left)
			{
				vTreeNode.push_back(curNode);
				curNode = curNode->left;
				continue;
			}
			vOut.push_back(curNode->val);


            while(NULL != curNode && NULL == curNode->right && vTreeNode.size()>0 )
            {
					curNode = vTreeNode.back();
					vTreeNode.pop_back();
					vOut.push_back(curNode->val);
			}
            curNode = curNode->right;
            
		}
		return vOut;
    }
};

//递归方法
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
      vector<int> vOut;	
      inorderTraversal(root,  &vOut);
      return vOut;
    }
    void inorderTraversal(TreeNode* root,  vector<int>* out) {
		if (NULL == root) {
			return;
		}

	    inorderTraversal(root->left, out);

		out->push_back(root->val);

        inorderTraversal(root->right, out);
    }
};
