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
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        res.add(level); 
        process(res, root.children);
        return res;
    }
    
    private void process(List<List<Integer>> res, List<Node> children) {
        if (children == null || children.size() ==0) {
            return;
        }
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            level.add(children.get(i).val);
        }
        res.add(level);
        for (int i = 1; i < children.size(); i++) {
            children.get(0).children.addAll(children.get(i).children);
        }
        process(res, children.get(0).children);
    }
}