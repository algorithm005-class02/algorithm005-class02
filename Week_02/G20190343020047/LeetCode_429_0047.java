/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, 0, result);
        return result;
    }

    public void helper(Node root, int depth, List<List<Integer>> result) {
        if (depth + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, depth + 1, result);
            }
        }
    }
}