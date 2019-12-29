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
        List<Integer> result = new ArrayList<>();
        order(root, result);
        return result;
    }
    private void order(Node root, List<Integer> result) {
        if (null != root) {
            if (null != root.children) {
                for (Node node : root.children) {
                    order(node, result);
                }
            }
            result.add(root.val);
        }
    }
}