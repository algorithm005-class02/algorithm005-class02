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
        List<Integer> res = new ArrayList<>();
        nPretorder(root, res);
        return res;
    }

    public void nPretorder(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (!root.children.isEmpty()) {
                for (Node subRoot : root.children) {
                    nPretorder(subRoot, res);
                }
            }
        }
    }
}