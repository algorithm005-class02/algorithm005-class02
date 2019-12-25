/**
 * 解题思路：
 * 用栈，保证栈顶的节点是当前遍历到的节点
 */
//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution589 {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    stack.add(child);
                }
            }
        }

        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
