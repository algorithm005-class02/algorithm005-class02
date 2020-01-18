package org.crayzer.leetcode.editor.en.dfs_bfs;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_515_FindLargestValueInEachTreeRow {
    class Solution {
        private List<Integer> res = new LinkedList<>();

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) return res;
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (depth == res.size()) {
                res.add(depth, root.val);
            }
            res.set(depth, Math.max(res.get(depth), root.val));
            if (root.left != null) dfs(root.left, depth + 1);
            if (root.right != null) dfs(root.right, depth + 1);
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


