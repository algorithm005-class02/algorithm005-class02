package week02.recursion.tree;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
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


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        for (Node temp : node.children) {
            helper(temp, list);
        }

        list.add(node.val);
    }

//    public List<Integer> postorder1(Node root) {
//        List<Integer> list = new ArrayList<Integer>();
//        Stack<Node> stack = new Stack<Node>();
//        Node node = root;
//        while (node != null || !stack.isEmpty()) {
//            stack.push(root);
//        }
//
//    }

}
