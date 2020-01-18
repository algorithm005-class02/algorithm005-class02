package week02.recursion.tree;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelorderTraversal {
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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(0, root, lists);
        return lists;
    }

    public void helper(int depth, Node root, List<List<Integer>> lists) {

        if (root == null) return;

        if (depth + 1 > lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth).add(root.val);

        for (Node temp : root.children) {
            helper(depth + 1, temp, lists);
        }
    }


}
