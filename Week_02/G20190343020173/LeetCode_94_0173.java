package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_BinaryTreeInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution3 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            if (root == null) return res;

            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.addLast(curr);
                    curr = curr.left;
                }

                curr = stack.pollLast();
                res.addLast(curr.val);
                curr = curr.right;
            }

            return res;
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            if (root == null) return res;

            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.add(curr);
                    curr = curr.left;
                }

                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }

            return res;
        }
    }

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            doInorderTraversal(root, res);
            return res;
        }

        private void doInorderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;

            doInorderTraversal(root.left, res);
            res.add(root.val);
            doInorderTraversal(root.right, res);
        }
    }
}
