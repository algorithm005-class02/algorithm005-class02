package org.crayzer.leetcode.editor.en.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_BinaryTreeLevelOrderTraversal {

    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                res.add(new LinkedList<>());

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    res.get(level).add(node.val);

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                level++;
            }
            return res;
        }
    }

    class Solution {
        private List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (depth == res.size()) {
                res.add(new LinkedList<>());
            }
            res.get(depth).add(root.val);
            if (root.left != null) dfs(root.left, depth + 1);
            if (root.right != null) dfs(root.right, depth + 1);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
