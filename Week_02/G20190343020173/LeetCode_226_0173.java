package org.crayzer.leetcode.editor.en.treez_recursion;

public class LeetCode_226_InvertBinaryTree {

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode l = invertTree(root.left);
            TreeNode r = invertTree(root.right);
            root.left = r;
            root.right = l;

            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


