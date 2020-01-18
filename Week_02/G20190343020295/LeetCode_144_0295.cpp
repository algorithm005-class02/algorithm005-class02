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
        if (root == NULL) return vector<int>();
        if (!root->left && !root->right) return vector<int>(1, root->val);
        stack<TreeNode*> treeSt;
        treeSt.push(root);  // 根节点入栈
        vector<int> myRes;
        while(!treeSt.empty()) {    
            TreeNode* tempNode = treeSt.top(); // 这里tempNode若为栈顶元素的引用，代码执行结果错误
            myRes.push_back(tempNode->val); 
            treeSt.pop();   // 栈顶元素出站
            if (tempNode->right)    // 栈先入后出，故访问顺序最后的先入栈
                treeSt.push(tempNode->right);
            if (tempNode->left)
                treeSt.push(tempNode->left);
        }
        return myRes;
    }

};