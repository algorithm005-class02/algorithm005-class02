/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;  // 左右子节点与本身类型相同，不应该把子节点作为terminator，而应该是自己
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    // 当前节点处
    // 如果当前节点不为空，入栈，去到其左节点
    // 如果当前节点为空，访问栈顶元素，并去到其右节点
    vector<int> inorderTraversal(TreeNode* root) {
        if (!root) return vector<int>();
        vector<int> myRes;
        stack<TreeNode*> nodeStack;
        TreeNode* currNode = root;
        while(currNode || !nodeStack.empty()){  //终止条件，栈空并且当前节点为空
            while(currNode){    //当前节点不为空
                nodeStack.push(currNode);   //入栈，让下一个node可以回到其父节点
                currNode=currNode->left;    //去到其左节点
            }
            //当前为空
            currNode=nodeStack.top();   // 回到其父节点
            nodeStack.pop();   // 删除栈顶元素，此时栈顶元素为当前节点的父节点
            myRes.push_back(currNode->val); //访问该节点
            currNode=currNode->right;   // 去到其右节点
        }
        return myRes;
    }
};