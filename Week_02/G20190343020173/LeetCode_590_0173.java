package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_N_aryTreePostorderTraversal {

    class Solution2 {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();

            if (root == null) return res;

            stack.add(root);
            while (!stack.isEmpty()) {
                Node curr = stack.pollLast();
                ((LinkedList<Integer>) res).addFirst(curr.val);

                stack.addAll(curr.children);
            }

            return res;
        }
    }

    class Solution1 {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new LinkedList<>();
            doPostorder(root, res);
            return res;
        }

        private void doPostorder(Node root, List<Integer> res) {
            if (root == null) return;

            for (Node n : root.children) {
                doPostorder(n, res);
            }
            res.add(root.val);
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
}
