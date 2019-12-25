/*
 * @lc app=leetcode.cn id=236 lang=cpp
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

#include<iostream>
#include<ctype.h>

using namespace std;

class Solution {

private:
    TreeNode* ans;

public:

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        recurseTree(root, p, q);
        return ans;
    }

    bool recurseTree(TreeNode* root, TreeNode* p, TreeNode* q){
        if(!root){
            return false;
        }

        int left = recurseTree(root->left, p, q) ? 1 : 0;
        int right = recurseTree(root->right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if(left + right + mid >= 2) {
            ans = root;
        }

        return left + right + mid > 0;
    }

};
// @lc code=end
