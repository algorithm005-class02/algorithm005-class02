/*
 * @lc app=leetcode.cn id=515 lang=cpp
 *
 * [515] 在每个树行中找最大值
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (56.62%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 11K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * 示例：
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * 输出: [1, 3, 9]
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
    vector<int> largestValues(TreeNode* root) {

        vector<int> nums;
        if(root == NULL) return nums;
        queue<TreeNode*> q;
        int level = 1;
        int cur_nums = 1;
        int nxt_nums = 0;
        int level_max = root->val;
        TreeNode* node;
        q.push(root);
        while(!q.empty()){
            node = q.front();
            q.pop();
            cur_nums--;
            if(node->left != NULL){
                q.push(node->left);
                nxt_nums++;
            }
            if(node->right != NULL){
                q.push(node->right);
                nxt_nums++;
            }
            level_max = node->val > level_max ? node->val : level_max;
            if(cur_nums == 0){
                nums.push_back(level_max);
                level ++;
                cur_nums = nxt_nums;
                nxt_nums = 0;
                level_max = 0x80000000;
            }
        }
        return nums;
    }
};
// @lc code=end

