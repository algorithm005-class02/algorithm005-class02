package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_N_aryTreePreorderTraversal {

    class Solution1 {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();

            if (root == null) return res;

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                res.add(node.val);

                Collections.reverse(node.children);
                stack.addAll(node.children);

                /* 如下操作错误 */
                // for (Node n : node.children) stack.offerFirst(n);
            }

            return res;
        }
    }

    /**
     * recursion
     */
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new LinkedList<>();
            doPreorder(root, res);
            return res;
        }

        private void doPreorder(Node node, List<Integer> res) {
            if (node == null) return;

            res.add(node.val);
            for (Node subNode : node.children) {
                doPreorder(subNode, res);
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

}
