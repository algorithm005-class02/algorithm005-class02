/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int lh = minDepth(root.left);
            int rh = minDepth(root.right);
            // 一个树只有一个子结点【链表】时，真正的最小深度为：左子结点深度（1） + 右子结点深度（0） + 1 = 2
            if (root.left == null || root.right == null) return lh + rh +1;
            return Math.min(lh, rh) + 1;
        }
    }
}
// @lc code=end

