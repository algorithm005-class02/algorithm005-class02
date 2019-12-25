package week02.recursion.tree;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
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


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        for (Node child : node.children) {
            helper(child, list);
        }
    }

}
