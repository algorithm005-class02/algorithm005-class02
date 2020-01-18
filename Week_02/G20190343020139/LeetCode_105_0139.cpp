/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * 执行用时 :28 ms, 在所有 cpp 提交中击败了57.67%的用户
 * 内存消耗 :19.5 MB, 在所有 cpp 提交中击败了22.14%的用户
 */


class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int rootidx = 0;
        return travel(preorder, rootidx, inorder, 0, inorder.size() - 1);
    }
    TreeNode* travel(vector<int>& preorder, int& rootidx, vector<int>& inorder, int start, int end){
        //terminator

        if(rootidx >= preorder.size() || start > end) return nullptr;

        //process
        TreeNode* res = new TreeNode(preorder[rootidx]);
        auto pos = distance(inorder.begin(), find(inorder.begin() + start, inorder.begin() + end, preorder[rootidx]));
        rootidx++;
        //drill down
        res->left = travel(preorder, rootidx, inorder, start, pos-1);
        res->right = travel(preorder, rootidx, inorder, pos+1, end);
        //reverse
        return res;
    }

};
