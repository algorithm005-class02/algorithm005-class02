
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 //自己写的
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL || p == NULL || q == NULL) return NULL;
        if (p == q) return p;
        vector<TreeNode*> v1, v2;
        getNodeSet(root, p ,v1);
        getNodeSet(root, q ,v2);
        for (int i = 0; i < v1.size(); i++)
        {
            for (int j = 0; j < v2.size(); j++)
            {
                if (v1[i] == v2[j]) return v1[i];
            }
        }
        return root;
    }

    bool getNodeSet(TreeNode* node, TreeNode* p, vector<TreeNode*> & vec)
    {
        if (node == NULL)
        {
            return false;
        }
       if (node == p) 
       {
           vec.push_back(node);
           return true;
       }
       
       if (getNodeSet(node->left, p, vec) || getNodeSet(node->right, p, vec))
       {
           vec.push_back(node);
           return true;
       }
       return false;
    }
};

//网上看的NB代码
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL || root == p || root == q) return root;

        TreeNode* left = lowestCommonAncestor(root->left, p , q);
        TreeNode* right = lowestCommonAncestor(root->right, p , q);

        if (left != NULL && right != NULL) return root;
        if (left == NULL && right == NULL) return NULL;
        return left == NULL ? right : left;
    }
};