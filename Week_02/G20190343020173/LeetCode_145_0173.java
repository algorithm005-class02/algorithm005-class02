package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_145_BinaryTreePostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();

            if (root == null) return res;

            stack.addLast(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pollLast();
                res.addFirst(curr.val);

                if (curr.right != null) stack.add(curr.right);
                if (curr.left != null) stack.add(curr.left);
            }
            return res;
        }
    }

    /**
     * 反人类，但是理解之后感觉很爽@！
     */
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            Set<TreeNode> set = new HashSet<>();

            TreeNode curr = root;
            while (curr != null && !stack.isEmpty()) {
                while (curr != null || !set.contains(curr)) {
                    stack.addLast(curr);
                    curr = curr.left;
                }

                curr = stack.getLast();
                if (curr.right == null || set.contains(curr)) {
                    res.addLast(curr.val);
                    set.add(curr);
                    stack.pollLast();

                    if (stack.isEmpty()) return res;
                    curr = stack.getLast();
                    curr = curr.right;
                } else {
                    set.add(curr);
                    curr = curr.right;
                }
            }

            return res;
        }
    }

    /**
     * 递归，必须掌握
     */
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            doPostorderTraversal(root, res);
            return res;
        }

        private void doPostorderTraversal(TreeNode root, List<Integer> res) {
            if (root == null) return;

            doPostorderTraversal(root.left, res);
            doPostorderTraversal(root.right, res);
            res.add(root.val);
        }
    }
}
