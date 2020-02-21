
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        getval(root, res);
        return res;
    }

    void getval(TreeNode* node, vector<int> & res)
    {
        if (node == NULL) return;
        res.push_back(node->val);
        getval(node->left, res);
        getval(node->right, res);
    }
};

//使用栈
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
       vector<int> ans;
       vector<TreeNode*> s;
       TreeNode* p = root;
       while (p || !s.empty())
       {
           while (p)
           {
               ans.push_back(p->val);
               s.push_back(p);
               p = p->left;
           }
           p = s.back();
           s.pop_back();
           p = p->right;
       }
       return ans;
    }
};