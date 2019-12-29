/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <unordered_map>
#include <vector>
using namespace std;
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> position;  //记录各数在中序中的位置
        for (int i = 0; i < inorder.size(); ++i) {
            position[inorder[i]] = i;
        }
        return build(preorder, 0, preorder.size(), inorder, 0, inorder.size(), position);
    }

    TreeNode* build(vector<int>& preorder, int pleft, int pright,
                    vector<int>& inorder, int qleft, int qright,
                    unordered_map<int, int>& position) {
        if (pleft >= pright || qleft >= qright) {
            return NULL;
        }
        int pos = position[preorder[pleft]] - qleft;  // 从中序序列获取左子树的长度
        auto root = new TreeNode(preorder[pleft]);
        root->left = build(preorder, pleft + 1, pleft + pos + 1, inorder, qleft, qleft + pos + 1, position);
        root->right = build(preorder, pleft + pos + 1, pright, inorder, qleft + pos + 1, qright, position);
        return root;
    }
};
