class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Node> nextStack = new ArrayList<>();
            result.add(list);
            for (Node item : stack) {
                list.add(item.val);
                nextStack.addAll(item.children);
            }
            stack = nextStack;
        }
        return result;
    }
}
