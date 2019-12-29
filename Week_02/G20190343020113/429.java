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
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        list.add(res);
        visit(root.children, list);
        return list;
    }

    public void visit(List<Node> root, List<List<Integer>> list) {
        List<Node> nodes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if(!root.isEmpty()) {
            for(Node children : root) {
                if(children != null) {
                    res.add(children.val);
                    nodes.addAll(children.children);
                }
            }
            list.add(res);
            visit(nodes, list);
        }
    }
}