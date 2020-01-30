/*
 * @lc app=leetcode.cn id=102 lang=cpp
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.90%)
 * Likes:    356
 * Dislikes: 0
 * Total Accepted:    72.3K
 * Total Submissions: 119.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
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
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        /**
         * if(node is visited) return
         * res = {};
         * visited = {};
         * queue = {};
         * queue.add(node);
         * cur_level_nums = 1;
         * next_level_nums = 0;
         * res_level = {};
         * while(queue){
         *      node = queue.pop();
         *      visited.add(node);
         *      res_level.add(node->value);
         *      cur_level_nums --;
         *      if(node->left != NULL){
         *          queue.push(node->left);
         *          next_level_nums++;
         *      }
         *      if(node->right != NULL){
         *          queue.push_back(node->right);
         *          next_level_nums++;
         *      }
         *      if(cur_level_nums == 0){
         *          res.add(res_level);
         *          res_level.clear();
         *          cur_level_nums = next_level_nums;
         *          next_level_nums = 0;
         *      }
         *      
         * }
         * 迭代
         */
        vector<vector<int>> res;
        if(root == NULL) return res;
        vector<int> level_res;
        queue<TreeNode*> q;
        struct TreeNode* node;
        q.push(root);
        int cur_level_nums = 1;
        int nxt_level_nums = 0;
        while(!q.empty()){
            node = q.front();
            level_res.emplace_back(node->val);
            q.pop();
            cur_level_nums--;
            if(node->left != NULL){
                q.push(node->left);
                nxt_level_nums++;
            }
            if(node->right != NULL){
                q.push(node->right);
                nxt_level_nums++;
            }
            if(cur_level_nums == 0){
                res.emplace_back(level_res);
                level_res.clear();
                cur_level_nums = nxt_level_nums;
                nxt_level_nums = 0;
            }


        }
        return res;  
    }
};
// @lc code=end

