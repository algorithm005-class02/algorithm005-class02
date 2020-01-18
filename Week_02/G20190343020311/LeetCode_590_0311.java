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
        List<Integer> res = new ArrayList<>();
        nPostorder(root, res);
        return res;
    }

    public void nPostorder(Node root, List<Integer> res) {
        if (root != null) {
            if (!root.children.isEmpty()) {
                for (Node subRoot : root.children) {
                    nPostorder(subRoot, res);
                }
            }
            res.add(root.val);
        }
    }
}