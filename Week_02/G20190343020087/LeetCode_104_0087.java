/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            // 接收每层返回的值：从最后一层开始+1后返回，加到根处停止，取左右子树的最大深度，最后加+1（根）
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);

            return Math.max(left_height, right_height) + 1;
        }
    }
}
// @lc code=end

