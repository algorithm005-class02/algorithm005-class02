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
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < root.children.size(); i++) {
            dfs(res, root.children.get(i));
        }
        res.add(root.val);
        return res;
    }
    
    private void dfs(List<Integer> res, Node root) {
        for (int i = 0; i < root.children.size(); i++) {
            dfs(res, root.children.get(i));
        }
        res.add(root.val);
    }
}