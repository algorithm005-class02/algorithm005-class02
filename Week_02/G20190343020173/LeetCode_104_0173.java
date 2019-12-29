package org.crayzer.leetcode.editor.en.treez_recursion;

public class LeetCode_104_MaximumDepthOfBinaryTree {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(root.left);
                int rightDepth = maxDepth(root.right);

                return Math.max(leftDepth, rightDepth) + 1;
            }
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

