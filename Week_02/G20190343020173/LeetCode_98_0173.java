package org.crayzer.leetcode.editor.en.treez_recursion;

public class LeetCode_98_ValidateBinarySearchTree {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return doValidBST(root, null, null);
        }

        private boolean doValidBST(TreeNode root, Integer lower, Integer upper) {
            if (root == null) return true;

            int val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (!doValidBST(root.left, lower, val)) return false;
            if (!doValidBST(root.right, val, upper)) return false;

            return true;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
