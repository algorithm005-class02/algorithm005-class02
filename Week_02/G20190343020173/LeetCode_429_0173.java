package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 */
public class LeetCode_429_N_aryTreeLevelOrderTraversal {

    class Solution3 {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> curLevel = new LinkedList<>();
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    curLevel.add(curr.val);

                    for (Node node : curr.children) queue.offer(node);
                }

                res.add(curLevel);
            }

            return res;
        }
    }

    class Solution2 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            dfs(root, 0);
            return res;
        }

        private void dfs(Node root, int depth) {
            if (root == null) return;

            if (depth + 1 > res.size()) res.add(new ArrayList<>());
            res.get(depth).add(root.val);

            for (Node node : root.children) {
                dfs(node, depth + 1);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
