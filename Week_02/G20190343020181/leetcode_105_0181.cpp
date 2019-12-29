
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 //使用递归
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> res;
        getVal(root,res);
        return res;
    }

    void getVal(Node* node, vector<int> & res)
    {
        if (node == NULL) return;
        for (auto  c : node->children)
        {
            getVal(c, res);
        }
        res.push_back(node->val);
    }
};

//使用栈
class Solution {
public:
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
		index = 0;
		return buildNode(preorder, inorder, 0, inorder.size() - 1);
	}

	TreeNode* buildNode(vector<int>& preorder, vector<int>& inorder, int l, int r)
	{
		if (r < l) return NULL;
		TreeNode* node = new TreeNode(preorder[index++]);
		int pos = FindPos(inorder, node->val, l, r);
		node->left = buildNode(preorder, inorder, l, pos -1);
		node->right = buildNode(preorder, inorder, pos + 1, r);
		return node;
	}

	int FindPos(vector<int>& inorder, int val, int l, int r)
	{
		for (int i = l; i <= r; i++)
		{
			if (inorder[i] == val)
				return i;
		}
		return -1;
	}

	int index;
};