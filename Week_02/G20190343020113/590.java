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
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        visit(root, list);
        return list;
    }

    public void visit(Node root, List<Integer> list) {
        if(root.children != null) {
            for(Node children : root.children) {
                visit(children, list);
            }
        }
        list.add(root.val);
    }
}