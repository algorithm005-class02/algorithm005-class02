package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 基于链表实现
     */
    class Solution2 {

        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            if (root == null) return result;

            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pollLast();
                result.add(treeNode.val);

                /* 注意：顺序 */
                if (treeNode.right != null) stack.add(treeNode.right);
                if (treeNode.left != null) stack.add(treeNode.left);
            }

            return result;
        }
    }

    /**
     * 基于栈实现
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();

            if (root == null) return result;

            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                result.add(treeNode.val);

                /* 栈是先入后出 */
                if (treeNode.right != null) stack.push(treeNode.right);
                if (treeNode.left != null) stack.push(treeNode.left);
            }

            return result;
        }
    }

    /**
     * 递归
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            doPreorderTraversal(root, res);
            return res;
        }

        private void doPreorderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;

            res.add(root.val);
            doPreorderTraversal(root.left, res);
            doPreorderTraversal(root.right, res);
        }
    }
}
