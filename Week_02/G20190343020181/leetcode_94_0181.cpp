
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> v1;
        getVal(root, v1);
        return v1;
    }

    void getVal(TreeNode* node, vector<int> & res_vec)
    {
        if (node == NULL) return;
        getVal(node->left, res_vec);
        res_vec.push_back(node->val);
        getVal(node->right, res_vec);
    }
};

//使用栈
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        vector<TreeNode*> s;
        TreeNode* p = root;
        while(p || !s.empty())
        {
            while(p)
            {
                s.push_back(p);
                p = p->left;
            }
            p = s.back();
            s.pop_back();
            ans.push_back(p->val);
            p = p->right;
        }
        return ans;
    }
};