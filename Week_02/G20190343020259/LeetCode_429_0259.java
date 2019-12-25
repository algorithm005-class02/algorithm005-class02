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
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> elements = new ArrayList<>();
        this.doLevelOrder(root, 0, elements);

        return elements;
    }

    private void doLevelOrder(Node node, int level, List<List<Integer>> elements) {
        if (node == null) {
            return;
        }

        if (level + 1 > elements.size()) {
            elements.add(new ArrayList<>());
        }

        elements.get(level).add(node.val);

        for (Node n : node.children) {
            this.doLevelOrder(n, level + 1, elements);
        }
    }

}