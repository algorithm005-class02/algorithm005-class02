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
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Queue<Node> child = new LinkedBlockingQueue<Node>();
	        if(root == null) return res;
	        child.add(root);
	        helper(child,res);
	        return res;
    }

	private void helper(Queue<Node> child, List<List<Integer>> res) {
		// TODO Auto-generated method stub
        Node[] temp = child.toArray(new Node[child.size()]);;
		List<Integer> reses = new ArrayList<Integer>();
		child.clear();
		if(temp.length != 0) {
        	for(Node node : temp) {
				reses.add(node.val);
				if(node.children.size() != 0) child.addAll(node.children);
			}
		}
		res.add(reses);
        if(child.size() != 0)
		    helper(child, res);
	}
}