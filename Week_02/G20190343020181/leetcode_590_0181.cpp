
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
    vector<int> postorder(Node* root) {
        vector<int> ans;
         if (root == NULL) return ans;
        vector<Node*> s;
        s.push_back(root);
        while (!s.empty())
        {
            Node* p = s.back();
            s.pop_back();
            ans.push_back(p->val);
            for (auto & c : p->children)
            {
                s.push_back(c);
            }
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};