/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
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
#include<vector>
#include<ctype.h>
#include<iostream>

using namespace std;

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;

        if(!root){
            return result;
        }

        vector<TreeNode*> v;
        v.push_back(root);
        while(v.size() > 0){
            TreeNode* pNode = v.back();
            if(pNode->left){
                v.push_back(pNode->left);
                pNode->left = NULL;
            }else{
                v.pop_back();
                result.push_back(pNode->val);
                if(pNode->right) v.push_back(pNode->right);
            }
        }   
        return result;  
    }

    vector<int> recursive_inorder(TreeNode* root){
        vector<int> v;
        inorderTraversal1(v,root);
        return v;
    }

    void inorderTraversal1(vector<int> &v,TreeNode* root){
        if(root == NULL){
            return;
        }
        inorderTraversal1(v, root->left);
        v.push_back(root->val);
        inorderTraversal1(v, root->right);
    }
};
