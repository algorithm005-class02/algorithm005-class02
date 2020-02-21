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
    public List<Integer> postorder(Node root) {
        List<Integer> values = new ArrayList<>();
        this.doPostorder(root, values);
        return values;
    }

    private void doPostorder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            this.doPostorder(child, values);
        }

        values.add(node.val);
    }
}