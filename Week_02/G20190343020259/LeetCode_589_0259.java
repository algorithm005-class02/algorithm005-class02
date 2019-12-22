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
    public List<Integer> preorder(Node root) {
        List<Integer> values = new ArrayList<>();
        this.doPreorder(root, values);
        return values;
    }

    private void doPreorder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.val);
        for (Node child : node.children) {
            this.doPreorder(child, values);
        }
    }
}