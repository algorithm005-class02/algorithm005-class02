class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return ret;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = skack.pop();
            list.add(root.val);
            for (Node node :root.children) {
                stack.add(node);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
